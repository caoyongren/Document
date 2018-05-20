#####<center>ubuntu指令大全
**命令关机**
sudo halt
sudo shutdown -h now
**定时关机**
sudo shutdown -h 23:00
sudo shutdown -h +60
**重启电脑**
sudo reboot
sudo shutdown -r now
**休眠**
sudo pm-hibernate
***
**查看ip地址网络相关信息**
ifconfig
***
**安装apt软件**
sudo apt-get install 软件名
sudo apt-get remove 软件名

**清理软件缓存**
sudo apt-get autoremove
**查看软件信息**
apt-cache show 软件名
**更新系统软件包**
apt-get upgrade
***
**安装deb软件包**
sudo dpkg -i 软件包名
**查看**
dpkg -l
**删除**
dpkg -r 软件名
**清楚配置**
dpkg -purge 软件名
***
**系统更新**
sudo apt-get update
sudo apt-get dist-upgrade 
or
sudo apt-get upgrade
**系统升级，版本升级**
sudo apt-get update
sudo apt-get install update-manager-core
sudo do-release-upgrade
***
**查看信息**
cat/proc/cpuinfo---cup信息
sudo lshw ---硬件信息
free -m ---显示内存

sudo fdisk -l 看硬盘分区

**挂载**
***
**复制文件**
sudo cp 文件位置  目的位置
sudo cp -r 文件位置  目的位置
sudo mv 文件位置 目的位置
**删除文件**
sudo rm -f 文件位置
sudo rm -rf 文件位置
**查看进程**
ps -AFL
pkill -9 进程号---中止
<hr>
