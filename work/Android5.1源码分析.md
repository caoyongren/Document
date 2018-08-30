Android 5.1.1

1 Android 5.1.1主目录

|-- bootable（启动引导相关代码）
|-- Makefile
|-- abi （applicationbinary interface，应用程序二进制接口，生成libgabi++.so相关库文件）
|-- art （google在4.4后加入用来代替Dalvik的运行时）
|-- bionic (Android的C library，即C库文件)
|-- bootable （启动引导相关代码）
|-- build （存放系统编译规则及generic等基础开发配置包）
|-- cts （Android兼容性测试套件标准）
|-- dalvik （dalvik JAVA虚拟机）
|-- developers (开发者用，存放几个例子)
|-- development （开发者需要的一些例程及工具）
|-- device (设备相关代码，这是各厂商需要配置和修改的代码)
|-- docs (介绍开源相关文档)
|-- external （android使用的一些开源的模组）
|-- frameworks （核心框架——java及C++语言）
|-- hardware （部分厂家开源的硬解适配层HAL代码）
|-- kernel (驱动内核相关代码)
|-- libcore (核心库相关)
|-- libnativehelper (JNI用到的库)
|-- ndk (ndk相关)
|-- out （编译完成后的代码输出目录）
|-- packages （应用程序包）
|-- pdk (google用来减少碎片化的东西)
|-- prebuilt （x86和arm架构下预编译的一些资源）
|-- sdk （sdk及模拟器）
|-- tools （工具）
|-- system （底层文件系统库、应用及组件——C语言）
|-- vendor （厂商定制代码） 由于每个目录都有挺多代码的，这里只简单说几个：

2. bionic 目录

|-- libc （C库）
| |-- arch-arm （ARM架构，包含系统调用汇编实现）
| |-- arch-x86 （x86架构，包含系统调用汇编实现）
| |-- bionic （由C实现的功能，架构无关）
| |-- docs （文档）
| |-- include （头文件）
| |-- inet （？inet相关，具体作用不明）
| |-- kernel （Linux内核中的一些头文件）
| |-- netbsd （？nesbsd系统相关，具体作用不明）
| |-- private （？一些私有的头文件）
| |-- stdio （stdio实现）
| |-- stdlib （stdlib实现）
| |-- string （string函数实现）
| |-- tools （几个工具）
| |-- tzcode （时区相关代码）
| |-- unistd （unistd实现）
| |-- zoneinfo （时区信息）
|-- libdl （libdl实现，dl是动态链接，提供访问动态链接库的功能）
|-- libm （libm数学库的实现，）
| |-- alpha （apaha架构）
| |-- amd64 （amd64架构）
| |-- arm （arm架构）
| |-- bsdsrc （？bsd的源码）
| |-- i386 （i386架构）
| |-- i387 （i387架构？）
| |-- ia64 （ia64架构）
| |-- include （头文件）
| |-- man （数学函数，后缀名为.3，一些为freeBSD的库文件）
| |-- powerpc （powerpc架构）
| |-- sparc64 （sparc64架构）
| |-- src （源代码）
|-- libstdc++ （libstdc++ C++实现库）
| |-- include （头文件）
| |-- src （源码）
|-- libthread_db （多线程程序的调试器库）
| |-- include （头文件）
|-- linker （动态链接器）
|-- benchmarks bootable 目录
|-- bootloader
| |-- lk
|-- recovery （系统恢复相关）
|-- applypatch （补丁工具）
|-- edify （升级脚本使用的edify脚本语言）
|-- fonts
|-- minadbd
|-- etc （init.rc恢复脚本）
|-- minui （一个简单的UI）
|-- minzip （一个简单的压缩工具）
|-- mtdutils （mtd工具）
|-- res （资源）
| |-- images （一些图片）
|-- tools （工具）
|-- tests
| |-- ota （OTA Over The Air Updates升级工具）
|-- uncrypt (一些权限相关的代码)
|-- updater （更新相关）

3. build目录

|-- core （核心编译规则）
|-- history （历史记录）
|-- libs
| |-- host （主机端库，有android “cp”功能替换）
|-- target （目标机编译对象）
| |-- board （开发平台）
| | |-- emulator （模拟器）
| | |-- generic （通用）
| | |-- idea6410 （自己添加的）
| | |-- sim （最简单）
| |-- product （开发平台对应的编译规则）
| |-- security （密钥相关）
|-- tools （编译中主机使用的工具及脚本）
|-- acp （Android "acp" Command）
|-- apicheck （api检查工具）
|-- atree （tree工具）
|-- check_prereq （检查编译时间戳工具）
|-- droiddoc （？作用不明，java语言，网上有人说和JDK5有关）
|-- fs_config （This program takes a list of files and directories）
|-- fs_get_stats （获取文件系统状态）
|-- releasetools （生成镜像的工具及脚本）
|-- rgb2565 （rgb转换为565）
|-- signapk （apk签名工具）
|-- zipalign (zip archive alignment tool) dalvik目录 dalvik虚拟机
|-- dexdump （dex反汇编）
|-- dexgen
|-- dexlist （List all methods in all concrete classes in a DEX file.）
|-- docs （文档）
|-- dx （dx工具，将多个java转换为dex）
|-- hit （？java语言写成）
|-- opcode-gen
|-- tools （工具）
|-- vm （虚拟机实现） development 目录 （开发者需要的一些例程及工具） |-- apps （一些核心应用程序） | |-- BluetoothDebug （蓝牙调试程序）
| |-- BuildWidget （版本号相关）
| |-- CustomLocale （自定义区域设置）
| |-- Development （开发）
| |-- DevelopmentSettings (开发设置)
| |-- Fallback (回调)
| |-- GestureBuilder （手势动作）
| |-- launchperf
| |-- NinePatchLab （点九图片相关）
| |-- OBJViewer （OBJ查看器）
| |-- SdkSetup （SDK安装器）
| |-- SettingInjectorSample （高级设置）
| |-- WidgetPreview （预览小部件）
|-- build （编译脚本模板）
|-- cmds （有个monkey工具）
|-- docs （文档）
|-- host （主机端USB驱动等）
|-- ide （集成开发环境）
|-- libraries (库)
|-- ndk （本地开发套件——c语言开发套件）
|-- perftests
|-- samples （例程）
| |-- AliasActivity （？）
| |-- ApiDemos （API演示程序）
| |-- BluetoothChat （蓝牙聊天）
| |-- BrowserPlugin （浏览器插件）
| |-- BusinessCard （商业卡）
| |-- Compass （指南针）
| |-- ContactManager （联系人管理器）
| |-- CubeLiveWallpaper （动态壁纸的一个简单例程）
| |-- FixedGridLayout （像是布局）
| |-- GlobalTime （全球时间）
| |-- HelloActivity （Hello）
| |-- Home （Home）
| |-- JetBoy （jetBoy游戏）
| |-- LunarLander （貌似又是一个游戏）
| |-- MailSync （邮件同步）
| |-- MultiResolution （多分辨率）
| |-- MySampleRss （RSS）
| |-- NotePad （记事本）
| |-- RSSReader （RSS阅读器）
| |-- SearchableDictionary （目录搜索）
| |-- SimpleJNI （JNI例程）
| |-- SkeletonApp （空壳APP）
| |-- Snake （snake程序）
| |-- SoftKeyboard （软键盘）
| |-- Wiktionary （？维基）
| |-- WiktionarySimple（？维基例程）
|-- scripts （脚本）
|-- sdk （sdk配置）
|-- sdk_overlay
|-- sys-img |-- testrunner （测试用）
|-- tools （一些工具）
|-- tutorials external 目录
|-- aes （AES加密）
|-- apache-http （网页服务器）
|-- astl （ASTL (Android STL) is a slimmed-down version of the regular C++ STL.）
|-- bison （自动生成语法分析器，将无关文法转换成C、C++）
|-- blktrace （blktrace is a block layer IO tracing mechanism）
|-- bluetooth （蓝牙相关、协议栈）
|-- bsdiff （diff工具）
|-- bzip2 （压缩工具）
|-- clearsilver （html模板系统）
|-- dbus （低延时、低开销、高可用性的IPC机制）
|-- dhcpcd （DHCP服务）
|-- dosfstools （DOS文件系统工具）
|-- dropbear （SSH2的server）
|-- e2fsprogs （EXT2文件系统工具）
|-- elfcopy （复制ELF的工具）
|-- elfutils （ELF工具）
|-- embunit （Embedded Unit Project）
|-- emma （java代码覆盖率统计工具）
|-- esd （Enlightened Sound Daemon，将多种音频流混合在一个设备上播放）
|-- expat （Expat is a stream-oriented XML parser.）
|-- fdlibm （FDLIBM (Freely Distributable LIBM)）
|-- freetype （字体）
|-- fsck_msdos （dos文件系统检查工具）
|-- gdata （google的无线数据相关）
|-- genext2fs (genext2fs generates an ext2 filesystem as a normal (non-root) user）
|-- giflib （gif库）
|-- googleclient （google用户库）
|-- grub （This is GNU GRUB, the GRand Unified Bootloader.）
|-- gtest （Google C++ Testing Framework）
|-- icu4c （ICU(International Component for Unicode)在C/C++下的版本）
|-- ipsec-tools (This package provides a way to use the native IPsec functionality ）
|-- iptables （防火墙）
|-- jdiff （generate a report describing the difference between two public Java APIs.）
|-- jhead （jpeg头部信息工具）
|-- jpeg （jpeg库）
|-- junit （JUnit是一个Java语言的单元测试框架）
|-- kernel-headers （内核的一些头文件）
|-- libffi （libffi is a foreign function interface library.）
|-- libpcap （网络数据包捕获函数）
|-- libpng （png库）
|-- libxml2 （xml解析库）
|-- mtpd （一个命令）
|-- netcat （simple Unix utility which reads and writes dataacross networkconnections）
|-- netperf （网络性能测量工具）
|-- neven （看代码和JNI相关）
|-- opencore （多媒体框架）
|-- openssl （SSL加密相关）
|-- openvpn （VPN开源库）
|-- oprofile （OProfile是Linux内核支持的一种性能分析机制。）
|-- ping （ping命令）
|-- ppp （pppd拨号命令，好像还没有chat）
|-- proguard （Java class file shrinker, optimizer, obfuscator, and preverifier）
|-- protobuf （a flexible, efficient, automated mechanism for serializing structured data）
|-- qemu （arm模拟器）
|-- safe-iop （functions for performing safe integer operations ）
|-- skia （skia图形引擎）
|-- sonivox （sole MIDI solution for Google Android Mobile Phone Platform）
|-- speex （Speex编/解码API的使用(libspeex)）
|-- sqlite （数据库）
|-- srec （Nuance 公司提供的开源连续非特定人语音识别）
|-- strace （trace工具）
|-- svox （Embedded Text-to-Speech）
|-- tagsoup （TagSoup是一个Java开发符合SAX的HTML解析器）
|-- tcpdump （抓TCP包的软件）
|-- tesseract （Tesseract Open Source OCR Engine.）
|-- tinyxml （TinyXml is a simple, small, C++ XML parser）
|-- tremor （I stream and file decoder provides an embeddable,integer-only library）
|-- webkit （浏览器核心）
|-- wpa_supplicant （无线网卡管理）
|-- xmlwriter （XML 编辑工具）
|-- yaffs2 （yaffs文件系统）
|-- zlib （a general purpose data compression library）

frameworks 目录 （核心框架——java及C++语言）

|-- base （基本内容）
| |-- api （？都是xml文件，定义了java的api？）
| |-- awt （AWT库）
| |-- build （空的）
| |-- camera （摄像头服务程序库）
| |-- cmds （重要命令：am、app_proce等）
| |-- core （核心库）
| |-- data （字体和声音等数据文件）
| |-- docs （文档）
| |-- graphics （图形相关）
| |-- include （头文件）
| |-- keystore （和数据签名证书相关）
| |-- libs （库）
| |-- location （地区库）
| |-- media （媒体相关库）
| |-- obex （蓝牙传输库）
| |-- opengl （2D-3D加速库）
| |-- packages （设置、TTS、VPN程序）
| |-- sax （XML解析器）
| |-- services （各种服务程序）
| |-- telephony （电话通讯管理）
| |-- test-runner （测试工具相关）
| |-- tests （各种测试）
| |-- tools （一些叫不上名的工具）
| |-- vpn （VPN）
| |-- wifi （无线网络）
|-- opt （可选部分）
| |-- com.google.android （有个framework.jar）
| |-- com.google.android.googlelogin （有个client.jar）
| |-- emoji （standard message elements）
|-- policies （Product policies are operating system directions aimed at specific uses）
|-- base
|-- mid （MID设备）
|-- phone （手机类设备，一般用这个）

hardware 目录 （部分厂家开源的硬解适配层HAL代码）

|-- broadcom （博通公司）
| |-- wlan （无线网卡）
|-- libhardware （硬件库）
| |-- include （头文件）
| |-- modules （Default (and possibly architecture dependents) HAL modules）
| |-- gralloc （gralloc显示相关）
| |-- overlay （Skeleton for the "overlay" HAL module.）
|-- libhardware_legacy （旧的硬件库）
| |-- flashlight （背光）
| |-- gps （GPS）
| |-- include （头文件）
| |-- mount （旧的挂载器）
| |-- power （电源）
| |-- qemu （模拟器）
| |-- qemu_tracing （模拟器跟踪）
| |-- tests （测试）
| |-- uevent （uevent）
| |-- vibrator （震动）
| |-- wifi （无线）
|-- msm7k （高通7k处理器开源抽象层）
| |-- boot （启动）
| |-- libaudio （声音库）
| |-- libaudio-qsd8k （qsd8k的声音相关库）
| |-- libcamera （摄像头库）
| |-- libcopybit （copybit库）
| |-- libgralloc （gralloc库）
| |-- libgralloc-qsd8k （qsd8k的gralloc库）
| |-- liblights （背光库）
| |-- librpc （RPC库）
|-- ril （无线电抽象层）
| |-- include （头文件）
| |-- libril （库）
| |-- reference-cdma-sms （cdma短信参考）
| |-- reference-ril （ril参考）
| |-- rild （ril后台服务程序）
|-- ti （ti公司开源HAL）
|-- omap3 （omap3处理器）
| |-- dspbridge （DSP桥）
| |-- libopencorehw （opencore硬件库）
| |-- liboverlay （overlay硬件库）
| |-- libstagefrighthw （stagefright硬件库）
| |-- omx （omx组件）
|-- wlan （无线网卡）

packages 目录

|-- apps （应用程序库）
| |-- BasicSmsReceiver （简单消息接收器）
| |-- Bluetooth （蓝牙）
| |-- Browser （浏览器，5.1以后默认是没有的，得找高通申请才会有源码，且源码很大，得自己编译）
| |-- Calculator （计算器）
| |-- Calendar （日历）
| |-- Camera （相机）
| |-- Camera2 (相机，4.4以后都用这个,但5.1以后用的是高通蛟龙相机)
| |-- CellBroadcastReceiver （小区广播）
| |-- CertInstaller （证书安装程序）
| |-- CMFileManager (文件管理器)
| |-- Contacts （联系人）
| |-- ContactsCommon (联系人)
| |-- DeskClock （时钟）
| |-- Dialer (拨号)
| |-- Email （邮箱）
| |-- Exchange （邮箱里的exchange账号）
| |-- FastPowerOn (快速开机)
| |-- Gallery （相册，和Camera类似，多了列表）
| |-- Gallery3D （相册，4.4以后都用这个）
| |-- HTMLViewer （浏览器附属界面，被浏览器应用调用，同时提供存储记录功能）
| |-- InCallUI (来电界面)
| |-- KeyChain (密钥链)
| |-- Launcher2 （登陆启动项，负责应用的调用）
| |-- LegacyCamera (相机，一般不用)
| |-- ManagedProvisioning (设备配置器)
| |-- Mms （短彩信业务）
| |-- Music （音乐播放器）
| |-- MusicFX (音效)
| |-- Nfc (NFC 服务)
| |-- OneTimeInitializer （一键清理）
| |-- PackageInstaller （安装、卸载程序的响应）
| |-- PhoneCommon （电话）
| |-- Protips (主菜单提示)
| |-- Provision （预设应用的状态，使能应用）
| |-- QuickSearchBox （快速查找）
| |-- Settings （设置：开机设定，包括电量、蓝牙、设备信息、界面、wifi等）
| |-- SmartCardService
| |-- SnapdragonCamera (蛟龙相机)
| |-- SoundRecorder （录音机）
| |-- SpareParts
| |-- SpeechRecorder
| |-- Stk （SIM卡应用）
| |-- Tag
| |-- Terminal
| |-- Trebuchet (5.1使用的launcher3)
| |-- TvSettings (Tv设置)
| |-- UnifiedEmail (邮箱相关)
| |-- VoiceDialer （语音识别通话）
|-- experimental
|-- inputmethods （输入法）
| |-- LatinIME （拉丁文输入法）
| |-- OpenWnn （OpenWnn日语输入法）
|-- providers （提供器，提供应用程序、界面所需的数据）
| |-- ApplicationsProvider （应用程序提供器，提供应用程序启动项、更新等）
| |-- CalendarProvider （日历提供器）
| |-- ContactsProvider （联系人提供器）
| |-- DownloadProvider （下载管理提供器）
| |-- MediaProvider （媒体提供器，提供存储数据）
| |-- PartnerBookmarksProvider (书签提供器)
| |-- TelephonyProvider （彩信提供器）
| |-- UserDictionaryProvider （用户字典提供器，提供用户常用字字典）
| |-- TvProvider
|-- screensavers (屏保)
| |-- Basic (基本互动屏保)
| |-- PhotoTable （照片屏保）
| |-- WebView （）
|-- services
| |-- Mms (短彩信服务)
| |-- Telecomm （通话服务）
| |-- Telephony （通话服务）
|-- wallpapers （墙纸）
| |-- Basic （基本墙纸，系统内置墙纸）
| |-- Galaxy4
| |-- HoloSpiral
| |-- LivePicker （选择动态壁纸）
| |-- MagicSmoke （壁纸特殊效果）
| |-- MusicVisualization （音乐可视化，图形随音乐而变化）
| |-- NoiseField
| |-- PhaseBeam
里面有一个隐藏的.git文件夹，内容都是一样的，没有有意义的代码，config看似乎是一个下载程序，因此认为
这些文件夹下没有实质东西。

prebuilt 目录 （x86和arm架构下预编译的一些资源）

|-- android-arm （arm-android相关）
| |-- gdbserver （gdb调试器）
| |-- kernel （模拟的arm内核）
|-- android-x86 （x86-android相关）
| |-- kernel （空的）
|-- common （通用编译好的代码，应该是java的）
|-- darwin-x86 （drawin x86平台）
| |-- toolchain （工具链）
| |-- arm-eabi-4.2.1
| |-- arm-eabi-4.3.1
| |-- arm-eabi-4.4.0
|-- darwin-x86_64 （drawin x86 64bit平台）
|-- linux-x86 （linux x86平台）
| |-- toolchain （工具链，我们应该主要用这个）
| |-- arm-eabi-4.2.1
| |-- arm-eabi-4.3.1
| |-- arm-eabi-4.4.0
| |-- i686-unknown-linux-gnu-4.2.1 （x86版编译器）
|-- linux-x86_64 （linux x86 64bit平台）
|-- windows （windows平台）
|-- windows-x86_64 （64bit windows平台）

system 目录 （底层文件系统库、应用及组件——C语言）

|-- Bluetooth （蓝牙相关）
|-- core （系统核心工具盒接口）
| |-- adb （adb调试工具）
| |-- cpio （cpio工具，创建img）
| |-- debuggerd （调试工具）
| |-- fastboot （快速启动相关）
| |-- include （系统接口头文件）
| |-- init （init程序源代码）
| |-- libacc （轻量级C编译器）
| |-- libctest （libc测试相关）
| |-- libcutils （libc工具）
| |-- liblog （log库）
| |-- libmincrypt （加密库）
| |-- libnetutils （网络工具库）
| |-- libpixelflinger （图形处理库）
| |-- libsysutils （系统工具库）
| |-- libzipfile （zip库）
| |-- logcat （查看log工具）
| |-- logwrapper （log封装工具）
| |-- mkbootimg （制作启动boot.img的工具盒脚本）
| |-- netcfg （网络配置netcfg源码）
| |-- nexus （google最新手机的代码）
| |-- rootdir （rootfs，包含一些etc下的脚本和配置）
| |-- sh （shell代码）
| |-- toolbox （toolbox，类似busybox的工具集）
| |-- vold （SD卡管理器）
|-- extras （额外工具）
| |-- latencytop （a tool for software developers ，identifying system latency happen）
| |-- libpagemap （pagemap库）
| |-- librank （Java Library Ranking System库）
| |-- procmem （pagemap相关）
| |-- procrank （Java Library Ranking System相关）
| |-- showmap （showmap工具）
| |-- showslab （showslab工具）
| |-- sound （声音相关）
| |-- su （su命令源码）
| |-- tests （一些测试工具）
| |-- timeinfo （时区相关）
|-- wlan （无线相关）
|-- ti （ti网卡相关工具及库）

vendor 目录 （厂家定制内容）

|-- aosp （android open source project）
| |-- products （一些板级规则）
|-- htc （HTC公司）
| |-- common-open （通用部分）
| | |-- akmd （解压img用的工具）
| |-- dream-open （G1开放部分）
| |-- prebuilt-open （预编译开放部分）
| |-- sapphire-open （sapphire这款型号开放内容）
|-- pv-open （没东西）
|-- qcom （里面基本是空的）
|-- sample （google提供的样例）
|-- apps （应用）
| |-- client （用户）
| |-- upgrade （升级）
|-- frameworks （框架）
| |-- PlatformLibrary （平台库）
|-- products （产品）
|-- sdk_addon （sdk添加部分）
|-- skins （皮肤）
|-- WVGAMedDpi （WVGA适用的图片）
=========================

链接：https://www.jianshu.com/p/ca6d3cd64ce6

