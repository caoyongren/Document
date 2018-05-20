###<center>获取系统APK的信息
***
    public void queryAppInfo() {
            PackageManager pm = this.getPackageManager();
            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            List<ResolveInfo> resolveInfos = pm.queryIntentActivities(mainIntent, 0);
            // Sort to resolveInfos :Matthew
            List<ResolveInfo> listEnglish = new ArrayList<>();
            List<ResolveInfo> listChina = new ArrayList<>();
            List<ResolveInfo> listNumber = new ArrayList<>();
            for (ResolveInfo info : resolveInfos) {
                String str = info.loadLabel(pm).toString().trim();
                int ch = str.charAt(0);
                if (ch >= '0' && ch <= '9') {
                    listNumber.add(info);
                } else {
                    if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                        listEnglish.add(info);
                    } else {
                        listChina.add(info);
                    }
                }
            }
            Collections.sort(listEnglish, new ResolveInfo.DisplayNameComparator(pm));
            Collections.sort(listChina, new ResolveInfo.DisplayNameComparator(pm));
            Collections.sort(listNumber, new ResolveInfo.DisplayNameComparator(pm));
            resolveInfos.clear();
            for (ResolveInfo number : listNumber) {
                resolveInfos.add(number);
            }
            for (ResolveInfo english : listEnglish) {
                resolveInfos.add(english);
            }
            for (ResolveInfo china : listChina) {
                resolveInfos.add(china);
            }
            mlistAppInfo.clear();
            for (ResolveInfo reInfo : resolveInfos) {
                File file = new File(reInfo.activityInfo.applicationInfo.sourceDir);
                Date systemDate = new Date(file.lastModified());
                ApplicationInfo applicationInfo = reInfo.activityInfo.applicationInfo;
                String activityName = reInfo.activityInfo.name;
                String pkgName = reInfo.activityInfo.packageName;
                String appLabel = (String) reInfo.loadLabel(pm);
                Drawable icon = reInfo.loadIcon(pm);
                Intent launchIntent = new Intent();
                launchIntent.setComponent(new ComponentName(pkgName, activityName));
                AppInfo appInfo = new AppInfo();
                appInfo.setAppLabel(appLabel);
                appInfo.setPkgName(pkgName);
                appInfo.setDate(systemDate);
                appInfo.setAppIcon(icon);
                appInfo.setIntent(launchIntent);
                mlistAppInfo.add(appInfo);
            }
        }
***
