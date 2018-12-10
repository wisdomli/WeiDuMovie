package com.bw.movie.weidumovie.presenter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.weidumovie.R;
import com.bw.movie.weidumovie.activity.MyMessageActivity;
import com.bw.movie.weidumovie.activity.UpdateUserActivity;
import com.bw.movie.weidumovie.aestoolkit.Base64;
import com.bw.movie.weidumovie.aestoolkit.EncryptUtil;
import com.bw.movie.weidumovie.bean.LoginBean;
import com.bw.movie.weidumovie.mvp.view.AppDelegate;
import com.bw.movie.weidumovie.net.HttpHelper;
import com.bw.movie.weidumovie.net.HttpUrl;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

import static android.app.Activity.RESULT_OK;
import static android.support.v4.app.ActivityCompat.shouldShowRequestPermissionRationale;

/**
 * 作者：温浩
 * 时间：2018/11/29
 */
public class MyMessageActivityPresenter extends AppDelegate implements View.OnClickListener {

    private ImageView image_back;
    private TextView phone_text;
    private TextView back_login;
    private TextView nickName_name;
    private TextView my_sex;
    private TextView my_email;
    private TextView my_birthday;
    private RelativeLayout my_name_user;
    private SimpleDraweeView pic_image;
    private static String path;//sd路径
    private static Bitmap head;//头像Bitmap
    private Bitmap bitmap1;
    private PopupWindow popWindow;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_message;
    }

    @Override
    public void initData() {
        super.initData();
        pic_image = get(R.id.pic_image);
        back_login = get(R.id.back_login);
        image_back = get(R.id.image_back);
        nickName_name = get(R.id.nickName);
        my_email = get(R.id.my_email);
        my_birthday = get(R.id.my_birthday);
        my_name_user = get(R.id.my_name_user);
        my_sex = get(R.id.my_sex);
        phone_text = get(R.id.phone_text);
        setOnClikLisener(this, R.id.pic_image);
        setOnClikLisener(this, R.id.image_back);
        setOnClikLisener(this, R.id.back_login);
        setOnClikLisener(this, R.id.my_name_user);
        path = Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    private Context context;

    @Override
    public void getContext(Context context) {
        super.getContext(context);
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                ((MyMessageActivity) context).finish();
                break;
            case R.id.back_login:
                boolean success = context.getSharedPreferences("config", 0).getBoolean("isLogin", false);
                if (success == true) {
                    Toast.makeText(context, "退出成功", Toast.LENGTH_SHORT).show();
                    context.getSharedPreferences("config", 0).edit().clear().commit();
                    ((MyMessageActivity) context).finish();
                } else {
                    Toast.makeText(context, "您还没有登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.my_name_user:
                Intent intent = new Intent(context, UpdateUserActivity.class);
                context.startActivity(intent);
                break;
            case R.id.pic_image:
                showPopwindow();
                break;
        }
    }

    //弹框
    private void showPopwindow() {
        View parent = ((ViewGroup) ((MyMessageActivity) context).findViewById(android.R.id.content)).getChildAt(0);
        View view = View.inflate(context, R.layout.camera_pop_menu, null);

        TextView btnCamera = (TextView) view.findViewById(R.id.btn_camera_pop_camera);
        TextView btnAlbum = (TextView) view.findViewById(R.id.btn_camera_pop_album);
        TextView btnCancel = (TextView) view.findViewById(R.id.btn_camera_pop_cancel);

        int width = context.getResources().getDisplayMetrics().widthPixels;
        int height = context.getResources().getDisplayMetrics().heightPixels;

        popWindow = new PopupWindow(view, width, height);

        popWindow.setFocusable(true);
        popWindow.setOutsideTouchable(false);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    //拍照
                    case R.id.btn_camera_pop_camera:

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            //当前系统大于等于6.0
                            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager
                                    .PERMISSION_GRANTED) {
                                //具有拍照权限，直接调用相机
                                //具体调用代码
                                // 设置调用系统摄像头的意图(隐式意图)
                                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                //设置照片的输出路径和文件名
                                //设置图片的名称
                                intent1.putExtra(MediaStore.EXTRA_OUTPUT, Uri
                                        .fromFile(new File(Environment.getExternalStorageDirectory(),
                                                "head.png")));
                                //开启摄像头
                                ((MyMessageActivity) context).startActivityForResult(intent1, 1);
                                popWindow.dismiss();

                            } else {
                                //不具有拍照权限，需要进行权限申请
                                ActivityCompat.requestPermissions(((MyMessageActivity) context), new String[]{Manifest.permission.CAMERA}, 100);
                            }
                        } else {
                            //当前系统小于6.0，直接调用拍照
                            // 设置调用系统摄像头的意图(隐式意图)
                            Log.i("jhktest", "onClick: " + "不用动态权限");
                            Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            //设置照片的输出路径和文件名
                            //设置图片的名称
                            intent1.putExtra(MediaStore.EXTRA_OUTPUT, Uri
                                    .fromFile(new File(Environment.getExternalStorageDirectory(),
                                            "head.png")));
                            //开启摄像头
                            ((MyMessageActivity) context).startActivityForResult(intent1, 1);
                            popWindow.dismiss();
                        }
                        break;
                    //相册
                    case R.id.btn_camera_pop_album:
//具体调用代码
                        //当前系统小于6.0，直接调用
                        // 设置调用系统相册的意图(隐式意图)
                        Intent intent1 = new Intent();
                        //设置值活动//android.intent.action.PICK
                        intent1.setAction(Intent.ACTION_PICK);
                        //设置类型和数据
                        intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                        // 开启系统的相册
                        ((MyMessageActivity) context).startActivityForResult(intent1, 2);
                        popWindow.dismiss();
                        break;
                    //取消
                    case R.id.btn_camera_pop_cancel:

                        break;
                }
                popWindow.dismiss();
            }
        };

        btnCamera.setOnClickListener(listener);
        btnAlbum.setOnClickListener(listener);
        btnCancel.setOnClickListener(listener);

        ColorDrawable dw = new ColorDrawable(0x30000000);
        popWindow.setBackgroundDrawable(dw);
        popWindow.showAtLocation(parent, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    public void onResume() {
        SharedPreferences config = context.getSharedPreferences("config", 0);
        String phone = config.getString("phone", "").toString();
        String nickName = config.getString("nickName", "").toString();
        String email = config.getString("email", "").toString();
        int sex = config.getInt("sex", 0);
        String birthday = config.getString("birthday", "");
        String headPic = config.getString("headPic", "").toString();
        //获取头像
        pic_image.setImageURI(headPic);
        //用户名
        if (nickName.isEmpty()){
            nickName_name.setText("");
        }else {
            nickName_name.setText(nickName);
        }
        //手机号
        if (phone.isEmpty()){
            phone_text.setText("");
        }else {
            phone_text.setText(phone);
        }
        //获取生日
        if (birthday.isEmpty()) {
            my_birthday.setText("");
        } else {
            my_birthday.setText(birthday);
        }
        //获取性别
        if (sex == 1) {
            my_sex.setText("男");
        } else if (sex == 2) {
            my_sex.setText("女");
        }
        }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                //相机
                case 1:

                    File temp = new File(Environment.getExternalStorageDirectory()
                            + "/head.png");
                    //裁剪图片
                    startPhotoZoom(Uri.fromFile(temp));
                    break;

                //相册
                case 2:

                    //裁剪图片
                    startPhotoZoom(data.getData());
                    break;

                //剪裁
                case 3:
                    Bundle extras = data.getExtras();
                    if (extras == null) {
                        return;
                    }
                    head = extras.getParcelable("data");
                    Log.i("jhktest", "onActivityResult: " + "dadasd");
                    if (head != null) {

                        String fileName = path + "/head.png";//图片名字
                        setPicToView(head);//保存在SD卡中
                        File file1 = new File(fileName);
                        Uri parse = Uri.parse("file://com.bw.movie/" + file1.getAbsolutePath());
                        Log.i("jhktest", "head: " + parse.toString());
                        pic_image.setImageURI(parse);
                        uploadImage(file1);
                    }
                    break;
            }
        }
    }








    private void uploadImage(File file) {


        HashMap<String, String> headMap = new HashMap<>();
        int userId = context.getSharedPreferences("config",0).getInt("userId",0);
        String sessionId = context.getSharedPreferences("config",0).getString("sessionId","");
        Log.i("userId",userId+"sessionId"+sessionId);
        headMap.put("userId", userId + "");
        headMap.put("sessionId", sessionId);


        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part image = MultipartBody.Part.createFormData("image", "head.png", requestBody);
        new HttpHelper().part("movieApi/user/v1/verify/uploadHeadPic", headMap, image).rosout(new HttpHelper.HttpLsener() {
            @Override
            public void suecss(String data) {
                if (data.contains("成功")) {
                    Toast.makeText(context, "上传头像成功", Toast.LENGTH_SHORT).show();

                    String pwd = context.getSharedPreferences("config",0).getString("pwd","");

                    String phone = context.getSharedPreferences("config",0).getString( "phone","");
                    //使用非对称加密密码

                    Map<String, String> map = new HashMap<>();
                    //拼接参数
                    map.put("phone", phone);
                    map.put("pwd", pwd);


                    //请求接口
                    new HttpHelper().post("movieApi/user/v1/login", map).rosout(new HttpHelper.HttpLsener() {
                        @Override
                        public void suecss(String data) {
                            if (data.contains("成功")) {
                                //解析数据
                                Gson gson = new Gson();                                               //1453sessionId15444140303381453
                                                                                                      //1453sessionId15444140197071453
                                LoginBean loginBean = gson.fromJson(data, LoginBean.class);
                                LoginBean.ResultBean resultBean = loginBean.getResult();
                                //存储用户头像信息
                                context.getSharedPreferences("config",0).edit()
                                        .putString("headPic",resultBean.getUserInfo().getHeadPic().trim())
                                .putInt( "userId", resultBean.getUserId())     //储存userid
                                .putString( "sessionId", resultBean.getSessionId()).commit();//储存sessionId
                         Log.i("userIds",resultBean.getUserId()+"sessionId"+resultBean.getSessionId());

                                LoginBean.ResultBean.UserInfoBean userInfo = resultBean.getUserInfo();

                                pic_image.setImageURI(userInfo.getHeadPic().trim());

                            } else {
                                Log.i("上傳",data);
                                Toast.makeText(context, "上传成功但是头像刷新失败", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void erorr(String data) {

                            Toast.makeText(context, "上傳頭像"+data, Toast.LENGTH_SHORT).show();
                        }
                    });

                } else {
                    Log.i("上傳頭像",data);
                    Toast.makeText(context, "上传头像失败", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void erorr(String data) {
                Log.i("jhktest", "fail: " + data);
                Toast.makeText(context,"qweqweqw"+ data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /***
     * 剪裁的方法
     */
    //剪裁的方法
    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 64);
        intent.putExtra("outputY", 64);
        intent.putExtra("return-data", true);
        ((MyMessageActivity) context).startActivityForResult(intent, 3);
    }


    /***
     * 保存到sd卡中
     */

    private void setPicToView(Bitmap mBitmap) {
        bitmap1 = mBitmap;
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //当前系统大于等于6.0
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager
                    .PERMISSION_GRANTED) {
                //请求过  直接用
                FileOutputStream b = null;
                File file = new File(path);
                file.mkdirs();// 创建文件夹
                String fileName = path + "/head.png";//图片名字

                try {
                    b = new FileOutputStream(fileName);
                    bitmap1.compress(Bitmap.CompressFormat.PNG, 100, b);// 把数据写入文件
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (b != null) {
                            //关闭流
                            b.flush();
                            b.close();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            } else {
                //没有去请求
                ActivityCompat.requestPermissions(((MyMessageActivity) context), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 111);

            }
        } else {
            //不大于6.0直接用
            FileOutputStream b = null;
            File file = new File(path);
            file.mkdirs();// 创建文件夹
            String fileName = path + "/head.png";//图片名字

            try {
                b = new FileOutputStream(fileName);
                bitmap1.compress(Bitmap.CompressFormat.PNG, 100, b);// 把数据写入文件
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (b != null) {
                        //关闭流
                        b.flush();
                        b.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length >= 1) {
                int cameraResult = grantResults[0];//相机权限
                boolean cameraGranted = cameraResult == PackageManager.PERMISSION_GRANTED;//拍照权限
                if (cameraGranted) {
                    //具有拍照权限，调用相机
                    // 设置调用系统摄像头的意图(隐式意图)
                    Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //设置照片的输出路径和文件名
                    //设置图片的名称
                    intent1.putExtra(MediaStore.EXTRA_OUTPUT, Uri
                            .fromFile(new File(Environment.getExternalStorageDirectory(),
                                    "head.png")));
                    //开启摄像头
                    ((MyMessageActivity) context).startActivityForResult(intent1, 1);
                    popWindow.dismiss();
                } else {
                    //不具有相关权限，给予用户提醒，比如Toast或者对话框，让用户去系统设置-应用管理里把相关权限开启
                    Toast.makeText(context, "您拒接了该权限入想开启请去系统设置-应用管理里把相关权限开启", Toast.LENGTH_SHORT).show();
                    if (!shouldShowRequestPermissionRationale(((MyMessageActivity) context), Manifest.permission.CAMERA)) {
                        //如果用户勾选了不再提醒，则返回false
                        //给予用户提醒，比如Toast或者对话框，让用户去系统设置-应用管理里把相关权限打开
                        Toast.makeText(context, "您拒接了该权限入想开启请去系统设置-应用管理里把相关权限开启", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }


        if (requestCode == 111) {
            int cameraResult = grantResults[0];//读写权限
            boolean cameraGranted = cameraResult == PackageManager.PERMISSION_GRANTED;//权限
            if (cameraGranted) {
                FileOutputStream b = null;
                File file = new File(path);
                file.mkdirs();// 创建文件夹
                String fileName = path + "/head.png";//图片名字

                try {
                    b = new FileOutputStream(fileName);
                    bitmap1.compress(Bitmap.CompressFormat.PNG, 100, b);// 把数据写入文件
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (b != null) {
                            //关闭流
                            b.flush();
                            b.close();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                //不具有相关权限，给予用户提醒，比如Toast或者对话框，让用户去系统设置-应用管理里把相关权限开启
                Toast.makeText(context, "您拒接了该权限入想开启请去系统设置-应用管理里把相关权限开启", Toast.LENGTH_SHORT).show();
                if (!shouldShowRequestPermissionRationale(((MyMessageActivity) context), Manifest.permission.CAMERA)) {
                    //如果用户勾选了不再提醒，则返回false
                    //给予用户提醒，比如Toast或者对话框，让用户去系统设置-应用管理里把相关权限打开
                    Toast.makeText(context, "您拒接了该权限入想开启请去系统设置-应用管理里把相关权限开启", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


}
