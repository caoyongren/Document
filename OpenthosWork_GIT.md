    1. 链接 Docker 服务器
      - ssh lh@192.168.0.180
    2. 启动
      - docker start -ai cyr-5.1
    3. 查看
      - ls
    4. 进入文件夹
      - cd cyr
    5. 创建文件夹
      - mkdir multiwindow
    6. repo 初始化
      - repo init -u git://192.168.0.185/lollipop-x86/manifest.git -b multiwindow
      ## multiwindow 是分之
    7. 同步下载代码
      - repo sync
    8. 同步到分之
      - repo start multiwindow --all
    9. 生成镜像
      - source build/envsetup.sh
    10. 选择模式
      - lunch 
      - 10.
    11. 编译
      - make -j16 iso_img
      - 16个线程
    12. 下载镜像
      - scp lh@192.168.0.180:/home/lh/cyr/multiwindow/out/target/product/x86_64/*.iso .
    
    13. 安装 qemu
      - sudo apt-get install qemu
    14. 启动
      - qemu-system-x86_64 --enable-kvm -m 1024 -cdrom android_x86_64.iso
    15. 做镜像
      - sudo fdisk -l
      - sudo mkfs -t vfat -I /dev/sdb1 
      - sudo dd if=android_x86_64.iso of=/dev/sdb1

      - 有时需要sync

    16. repo sync  重新下载代码

    17. 取log
      - 1. 启动模拟器
      - 2. adb kill-server
      - 3. adb logcat > DEBUG.log
      - 4. 另起一个终端： 
        tail -f DEBUG.log

    18. 打印堆栈
      - Log.d(TAG, Log.getStackTraceString(new Throwable()));

      - adb logcat | grep 检索的字符串
      - adb logcat | grep -i myapp #忽略大小写
    
    19. openthos中取log
      - alt + f1 
      - cd storage/emuted/legacy/
      - vim DEBUG.log
      - vim DEBUG.log


    20.远程
      - killall -9 adb 
      - adb connect ip
      - adb install ./../../.apk
    
    ============
   ### 代码格式

   1. 注意空格(少用TAB)
     - 距离 4个空格
     - 级别对齐
     - 不能有多余空格
     - （diff 中可以看出有无空格）
     - / $
   2.长度
     - > 95字符
     - 分行注意：1. 可读性
                 2. 美观性
   3. 括号中两个参数 ，逗号后要加 空格

   4. if （）{
      } else {
      
      }
   5. 方法名后Method() {}

   6. 两个方法间加空行。

   7. Intent字符串 定义在 Intent.java中。

   8. 软编码
     - 布局中 style theme
     - string dimen color;

     mContext.getResources().getDimensionPixelSize(R.dimen.notification_min_height);
     getResources().getString(R.string.selinux_status_disabled);

     int widthPw = mContext.getResources().getDimensionPixelSize
                                    (R.dimen.popupwindow_width);
                                                    int heightPw = mContext.getResources().getDimensionPixelSize
                                                                                   (R.dimen.popupwindow_height);

                                                                                     
   9. 字符常量： 定义成public final string STRING_PATH = "com.openthos";
     (定义在一个类，多个类使用)

   10. 注释：和源码一样规格
    /*
     *
     **/

   11. 对外暴露属性： 封装 set get 方法；

   12. 代码要简短，少写一行，就少一行；

   13. 最重要的原则；
     - Don`t make me think.
