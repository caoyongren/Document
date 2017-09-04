### ubuntu的常用指令
  - 切换JDK
    - sudo update-java-alternatives -s java-8-oracle
    - sudo update-java-alternatives -s java-7-oracle
    - update-alternatives --config java
    - update-alternatives --config javac
    - 编辑: /usr/lib/jvm

  - sudo reboot 重启
  - 安装无线网卡驱动
    - sudo apt-get install linux-headers-generic build-essential dkms
    - sudo apt-get update(optional maybe)
    - sudp apt-get install linux-source
    - sudo apt-get install --reinstall bcmwl-kernel-source
    - sudo modprobe wl
    - sudo dpkg -i wireless-bcm43142-dkms_6.20.55.19-1_amd64.deb 


  - 安装音乐播放器:
    - sudo apt-get install moc
    - mocp  #打开音乐播放器

  - ctrl + shift + E  # 垂直分割窗口
  - ctrl + shift + o  # 水平分割窗口
  - ctrl + shift + c  # 复制
  - ctrl + shift + z  # 从放大至全屏到多窗口

 
