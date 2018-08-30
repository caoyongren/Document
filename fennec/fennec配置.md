## fennec 环境配置
***
##### 从不放弃
#### 前言
  *最初接触fennec的工作，什么都不知道，然后两周什么工作成绩也没出来，被领导吊一顿，然后换了其他工作，但是我不想放弃，就自己在本地开始了研究 。。。*
  ***
#### 先来配置开发环境
```
## ubuntu 16.04
sudo add-apt-repository ppa:openjdk-r/ppa

sudo apt-get update

sudo apt-get install yasm git python-dbus mercurial automake autoconf autoconf2.13 build-essential ccache python-dev python-pip python-setuptools unzip uuid zip zlib1g-dev openjdk-7-jdk wget libncurses5:i386 libstdc++6:i386 zlib1g:i386

mkdir /firefox

cd /firefox

curl -sf -L https://static.rust-lang.org/rustup.sh > rustup.sh

chmod +x rustup.sh

./rustup.sh

./rustup.sh --add-target=i686-linux-android

源码下载
git clone https://github.com/mozilla/gecko-dev.git

git://192.168.0.185/gecko-dev.git (实验室)

cd gecko-dev

git checkout -b r49-2016101919 remotes/origin/MOBILE4902_2016101919_RELBRANCH


预处理
./mach bootstrap

选择4（Firefox for android）

等下载完ndk / Sdk （需要一定耐心）
下载后的路径: /home/自己系统的名字/.mozbuild/

cd ../

scp lh@192.168.0.180:/home/lh/wjx/sdk.tar.gz .

tar -zxvf sdk.tar.gz

解压后会在/firefox/Sdk目录下。

cd gecko-dev

vi mozconfig

增加以下内容

ac_add_options --enable-application=mobile/android

ac_add_options --target=i386-linux-android

## Sdk的绝对路径
ac_add_options --with-android-sdk="/firefox/Sdk"

## ndk的绝对路径
ac_add_options --with-android-ndk="/root/.mozbuild/android-ndk-r11b"

mk_add_options MOZ_OBJDIR=./objdir-all

mk_add_options MOZ_MAKE_FLAGS="-j4"


关闭mozconfig，然后再。

vi mobile/android/confvars.sh

注释掉MOZ_INSTALL_TRACKING， （可以先不注释进行尝试，有时真不需要注释）若编译失败，再注释；

编译打包安装 
./mach build

./mach package

./mach install
```
[参考文章](https://developer.mozilla.org/en-US/docs/Mozilla/Developer_guide/Build_Instructions/Simple_Firefox_for_Android_build)
