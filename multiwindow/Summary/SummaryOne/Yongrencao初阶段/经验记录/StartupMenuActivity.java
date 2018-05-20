//  最终版本
List<ResolveInfo> listEnglish = new ArrayList<>();
            List<ResolveInfo> listChina = new ArrayList<>();
            List<ResolveInfo> listNumber = new ArrayList<>();
            for (ResolveInfo info : resolveInfos) {
                String str = info.loadLabel(pm).toString().trim();
                int ch = str.charAt(0);
                if (ch >= ASCII_NUMBER_MIN && ch <= ASCII_NUMBER_MAX) {
                    listNumber.add(info);
                } else {
                    if ((ch >= ASCII_CHARACTER_BIG_MIN && ch <= ASCII_CHARACTER_BIG_MAX)
                        ||(ch >= ASCII_CHARACTER_LITTLE_MIN
                        && ch <= ASCII_CHARACTER_LITTLE_MAX)) {
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

public class StartupMenuActivity extends Activity implements OnClickListener,
                 OnEditorActionListener {

        public static final int FILTER_ALL_APP = 1;
        public static final int FILTER_SYSYTEM_APP = 2;
        public static final int FILTER_THIRD_APP = 3;
        public static final int FILTER_THIRD_APP_TYPE_X = 260;
        public static final int FILTER_THIRD_APP_TYPE_Y = 845;
        public static final int FILTER_THIRD_APP_TYPE_UI_X = 153;
        public static final int FILTER_THIRD_APP_TYPE_UI_Y = 125;

        public static StartMenuDialog mStartMenuDialog;
        public static StartMenuUsuallyDialog mStartMenuUsuallyDialog;
        public static List<AppInfo> mlistAppInfo = null;
        public static StartupMenuActivity StartupMenuActivity;
        public static  List<AppInfo> mlistViewAppInfo = null;
        private Map<Integer, Boolean> isCheckedMap = null;

        private Context mContext;
        private PopupWindow mPopupWindow;
        private StartupMenuAdapter mBrowseAppAdapter, mBroAdapter;
        public static StartupMenuUsuallyAdapter mUsuallyAdapter;
        private MySqliteOpenHelper mMsoh;
        private SQLiteDatabase mdb;
        BaseSettingDialog mPowerSourceDialog;
        BaseSettingDialog targetDialog;

        private int mNumber;
        private int CLICKS = 0;
        private boolean mListViewOpen = false;
        private boolean mIsHasReayDb;
        private String mEtext;

        private GridView gv_view;
        private ListView mListView;
        private EditText mEditText;
        private View  my_computer;
        private ImageView mIvArrowGray;
        private TextView mTvSortShow;
        private LinearLayout mIvArrowWhite;
        public static List<AppInfo> mListViewEight;
        private TextView mClickSort;
        private TextView mTimeSort;
        private TextView mNameSort;
        private int mClickSortStatus = 1;
        private int mTimeSortStatus = 1;
        private int mNameSortStatus = 1;
        private boolean mOnlyNameSort = false;
        private LinearLayout mSelectLayout;
        private View mSelectView;
        private SharedPreferences sharedPreference;
        private String mNameSortText;
        private String mTimeSortText;
        private String mClickSortText;
        private String mType;
        private int mOrder;
        private Handler mHandler;
        private int mFinishFlag = 0;
        private int mGetValueFlag = 1;
        @Override
        protected void onNewIntent(Intent intent) {
            super.onNewIntent(intent);
            System.exit(0);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH, WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH);
            getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);
            setContentView(R.layout.start_activity);
            mContext=this;

            mMsoh = new MySqliteOpenHelper(StartupMenuActivity.this, "Application_database.db", null, 1);
            mdb = mMsoh.getWritableDatabase();

            gv_view = (GridView) findViewById(R.id.gv_view);
            StartupMenuActivity.this.setFinishOnTouchOutside(true);
            mlistAppInfo = new ArrayList<AppInfo>();
            isCheckedMap = new HashMap<Integer, Boolean>();
            mBrowseAppAdapter = new StartupMenuAdapter(this, mlistAppInfo ,isCheckedMap);
            //gv_view.setOnItemClickListener(this);

            TextView system_setting = (TextView) findViewById(R.id.system_setting);
            my_computer = (TextView) findViewById(R.id.my_computer);
            TextView powerOff = (TextView) findViewById(R.id.power_off);
            mStartMenuDialog = new StartMenuDialog(this, R.style.dialog);
            mStartMenuUsuallyDialog = new StartMenuUsuallyDialog(this, R.style.dialog);
            my_computer.setOnClickListener(this);
            system_setting.setOnClickListener(this);
            my_computer.setOnHoverListener(hoverListener);
            system_setting.setOnHoverListener(hoverListener);
            powerOff.setOnHoverListener(hoverListener);

            ImageView imView = (ImageView) findViewById(R.id.iv_view);
            mIvArrowGray = (ImageView) findViewById(R.id.iv_arrow_gray);
            mTvSortShow = (TextView) findViewById(R.id.tv_sort_show);
            mEditText = (EditText) findViewById(R.id.et_text);
            mIvArrowWhite = (LinearLayout) findViewById(R.id.iv_arrow_white);
            mIvArrowWhite.setOnClickListener(this);
            mTvSortShow.setOnClickListener(this);
            imView.setOnClickListener(this);
            mEditText.setOnEditorActionListener(this);
            mEditText.addTextChangedListener(watcher);

            mTvSortShow.setText("");
            mIvArrowGray.setImageResource(R.drawable.ic_starter_down_arrow_gray);
            mHandler=new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    if (msg.what == mFinishFlag) {
                        mUsuallyAdapter = new StartupMenuUsuallyAdapter(StartupMenuActivity.this,
                                                                mListViewEight);
                        mListView.setAdapter(mUsuallyAdapter);
                    } else if (msg.what == mGetValueFlag) {
                        selectAppShow();
                    }
                }
            };
            new mThread().start();
            mListView = (ListView) findViewById(R.id.lv_view);
            initSelectLayout();
            // selectAppShow();
        }

        public void initSelectLayout() {
            mSelectLayout =  new LinearLayout(StartupMenuActivity.this);
            mSelectLayout.setBackgroundColor(Color.WHITE);
            mSelectView = LayoutInflater.from(StartupMenuActivity.this).inflate(
                                         R.layout.showsort_activity, null);
            mSelectView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                                            LayoutParams.WRAP_CONTENT));
            mClickSort = (TextView) mSelectView.findViewById(R.id.click_sort);
            mTimeSort = (TextView) mSelectView.findViewById(R.id.time_sort);
            mNameSort = (TextView) mSelectView.findViewById(R.id.name_sort);

            mClickSortText = mClickSort.getText().toString();
            mTimeSortText = mTimeSort.getText().toString();
            mNameSortText = mNameSort.getText().toString();
            //TextView type_sort = (TextView) tv.findViewById(R.id.type_sort);

            mClickSort.setOnClickListener(this);
            mTimeSort.setOnClickListener(this);
            mNameSort.setOnClickListener(this);
            //type_sort.setOnClickListener(this);
            mClickSort.setOnHoverListener(hoverListeners);
            mTimeSort.setOnHoverListener(hoverListeners);
            mNameSort.setOnHoverListener(hoverListeners);
            mSelectLayout.addView(mSelectView);
        }

        View.OnHoverListener hoverListeners= new View.OnHoverListener() {
            public boolean onHover(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_HOVER_ENTER:
                        v.setBackgroundResource(R.color.rightMenuFocus);
                        break;
                    case MotionEvent.ACTION_HOVER_EXIT:
                        v.setBackgroundResource(R.color.showSortBackground);
                        break;
                }
                return false;
            }
        };

        public void selectAppShow() {
            if (mType.equals("sortName")) {
                mTvSortShow.setText(R.string.name_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_down_arrow_gray);
                nameSort();
            } else if (mType.equals(mNameSortText) && mOrder == 1) {
                mTvSortShow.setText(R.string.name_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_down_arrow_gray);
                nameSort();
            } else if (mType.equals(mNameSortText) && mOrder == -1) {
                mTvSortShow.setText(R.string.name_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_rank_arrow_gray);
                mNameSortStatus = -1;
                mOnlyNameSort = true;
                nameSort();
            } else if (mType.equals(mTimeSortText) && mOrder == 1) {
                mTvSortShow.setText(R.string.time_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_down_arrow_gray);
                timeSort();
            } else if (mType.equals(mTimeSortText) && mOrder == -1) {
                mTvSortShow.setText(R.string.time_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_rank_arrow_gray);
                mTimeSortStatus = -1;
                timeSort();
            } else if (mType.equals(mClickSortText) && mOrder == 1) {
                mTvSortShow.setText(R.string.click_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_down_arrow_gray);
                mEditText.setText("");
                clickSort();
            } else if (mType.equals(mClickSortText) && mOrder == -1) {
                mTvSortShow.setText(R.string.click_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_rank_arrow_gray);
                mEditText.setText("");
                mClickSortStatus=-1;
                clickSort();
            }
        }

        View.OnHoverListener hoverListener = new View.OnHoverListener() {
            public boolean onHover(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_HOVER_ENTER:
                        v.setBackgroundResource(R.drawable.power_background);
                        break;
                    case MotionEvent.ACTION_HOVER_EXIT:
                        v.setBackgroundResource(R.color.appUsuallyBackground);
                        break;
                }
                return false;
            }
        };

        class mThread extends Thread {
            public void run(){
                BackstageRenewalData();
                sharedPreference = getSharedPreferences("click", Context.MODE_PRIVATE);
                int isClick = sharedPreference.getInt("isClick", 0);
                mType = sharedPreference.getString("type", "sortName");
                mOrder = sharedPreference.getInt("order", 0);
                Message m = new Message();
                m.what = mGetValueFlag;
                mHandler.sendMessage(m);
                if (isClick == 1) {
                    mListViewOpen = true;
                    queryCommonlyUsedSoftware();
                }
            }
        }
/*            方案 二 */

    List<ResolveInfo> resolve = new ArrayList<>();
    String[] strInfo = new String[resolveInfos.size()];
    for (ResolveInfo nameApp : resolveInfos) {
        for (int i = 0; i < strInfo.length; i++) {
            strInfo[i] = (String)nameApp.loadLabel(pm);
        }
    }
    Comparator<Object> comparator = Collator.getInstance(java.util.Locale.CHINA);
    Arrays.sort(strInfo,comparator);
    resolveInfos.clear();
    for (int i = 0; i < strInfo.length; i++) {
        for (ResolveInfo info : resolve) {
            String str = (String)info.loadLabel(pm);
            if (strInfo[i].equals(str)) {
                resolveInfos.add(info);
            }
        }
    }
    Log.i("--","zx"+resolveInfos+"strInfo"+strInfo.length);// 17
//    ------------
/*   方案 一*/
List<ResolveInfo> resolve = new ArrayList<ResolveInfo>();
    List<String> list = new ArrayList<>();
    for (ResolveInfo info : resolveInfos) {
        resolve.add(info);
        String strInfo = (String)info.loadLabel(pm);
        list.add(strInfo);
    }
    Comparator<Object> comparator = Collator.getInstance(java.util.Locale.CHINA);
    Collections.sort(list,comparator);
    resolveInfos.clear();
    for (int i=0 ; i < list.size() ; i++) {
        String strInfo = list.get(i);
        for (ResolveInfo appName : resolve) {
            if (strInfo.equals((String)appName.loadLabel(pm))) {
                resolveInfos.add(appName);
            }
        }
    }
    Log.i("----","zx----"+resolveInfos.size()+"nm"+resolveInfos);
//    ---------------------------

    /*  方案  三*/
    // 写比较器
    public class AppNameComparator implements Comparator<ResolveInfo>{
        private Context context ;
        PackageManager pm = context.getPackageManager();

        @Override
        public int compare(ResolveInfo resolveInfo, ResolveInfo resovle) {
            Collator collator = Collator.getInstance(Locale.CHINA);
            String strInfo = resolveInfo.loadLabel(pm).toString();
            String str = resovle.loadLabel(pm).toString();
            if (collator.compare(strInfo,str) > 0) {
                return 1;
            } else if (collator.compare(strInfo,str) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    Collections.sort(list, new AppNameComparator());

    /*  方案  4*/
    //   在一中使用


    class AppNameComparator implements Comparator<ResolveInfo>{
        private Context context = null;
        PackageManager pm = context.getPackageManager();

        @Override
        public int compare(ResolveInfo resolveInfo, ResolveInfo resovle) {
            Collator collator = Collator.getInstance(Locale.CHINA);
            String strInfo = resolveInfo.loadLabel(pm).toString();
            String str = resovle.loadLabel(pm).toString();
            if (collator.compare(strInfo,str) > 0) {
                return 1;
            } else if (collator.compare(strInfo,str) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }




    import java.util.Comparator;
    import java.text.Collator;
    import java.util.Arrays;
    import android.util.Log;



        public void queryAppInfo() {
            PackageManager pm = this.getPackageManager();
            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

            List<ResolveInfo> resolveInfos = pm.queryIntentActivities(mainIntent, 0);
            List<String> list = new ArrayList<>();
            for (ResolveInfo info : resolveInfos) {
                list.add(info.loadLabel(pm).toString());
            }
            Comparator<Object> comparator = Collator.getInstance(java.util.Locale.CHINA);
            Collections.sort(list,comparator);

            List<ResolveInfo> listEnglish = new ArrayList<>();
            List<ResolveInfo> listChina = new ArrayList<>();
            List<ResolveInfo> listNumber = new ArrayList<>();
            for (ResolveInfo info : resolveInfos) {
                String str = info.loadLabel(pm).toString().trim();
                Boolean flag = isEnglish(str);
                int ch = str.charAt(0);
                if (ch <48 || ch > 78) {
                    if (flag == true) {
                        listEnglish.add(info);
                    } else {
                        listChina.add(info);
                    }
                } else {
                    listNumber.add(info);
                }

            }

            Collections.sort(listEnglish,new ResolveInfo.DisplayNameComparator(pm));
            Collections.sort(listChina,new ResolveInfo.DisplayNameComparator(pm));
            resolveInfos.clear();

            for (ResolveInfo english : listEnglish) {
                resolveInfos.add(english);
            }
            for (resolveInfos china : listChina) {
                resolveInfos.add(china);
            }


            resolveInfos.clear();
            for (String str : list) {
                for (ResolveInfo info : resolveInfos) {
                    if (str.equals(info.loadLabel(pm).toString())) {
                        resolveInfos.add(info);
                    }
                }
            }
            Log.i("----","zx----"+resolveInfos.size()+"nm"+resolveInfos);
           // Collections.sort(resolveInfos,new ResolveInfo.DisplayNameComparator(pm));

            if (mlistAppInfo != null) {
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
        }

        public void queryCommonlyUsedSoftware() {
            if (mListViewOpen) {
                mlistViewAppInfo = new ArrayList<AppInfo>();
                Cursor cs = mdb.rawQuery("select distinct * from perpo", new String[] {});
                while (cs.moveToNext()) {
                    String label = cs.getString(cs.getColumnIndex("label"));
                    String pkgName = cs.getString(cs.getColumnIndex("pkname"));
                    String stringDate = cs.getString(cs.getColumnIndex("date"));
                    Drawable icon = null;
                    Date date = null;
                    try {
                        icon = getPackageManager().getApplicationIcon(pkgName);
                        date = ConverToDate(stringDate);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int number = cs.getInt(cs.getColumnIndex("click"));
                    if (number > 0) {
                        Intent intent = getPackageManager().getLaunchIntentForPackage(pkgName);
                        AppInfo appInfo = new AppInfo();
                        appInfo.setAppLabel(label);
                        appInfo.setPkgName(pkgName);
                        appInfo.setDate(date);
                        appInfo.setAppIcon(icon);
                        appInfo.setNumber(number);
                        appInfo.setIntent(intent);
                        mlistViewAppInfo.add(appInfo);
                    }
                }

                Collections.sort(mlistViewAppInfo, new Comparator<AppInfo>() {
                    public int compare(AppInfo lhs, AppInfo rhs) {
                        Double rScore = (double) rhs.getNumber();
                        Double iScore = (double) lhs.getNumber();
                        return (rScore.compareTo(iScore));
                    }
                });
                mListViewEight = new ArrayList<>();
                for (int i = 0; i < 8; i++) {
                    if (i >= mlistViewAppInfo.size()) {
		        break;
                    }
                    AppInfo appInfo = mlistViewAppInfo.get(i);
                    mListViewEight.add(appInfo);
                }
                //selectAppShow();
                Message m = new Message();
                m.what = mFinishFlag;
                mHandler.sendMessage(m);
            }
        }

        public void BackstageRenewalData() {
            PackageManager pm = this.getPackageManager();
            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            List<ResolveInfo> resolveInfos = pm.queryIntentActivities(mainIntent, 0);
            Collections.sort(resolveInfos,new ResolveInfo.DisplayNameComparator(pm));
            for (ResolveInfo reInfo : resolveInfos) {
                File file = new File(reInfo.activityInfo.applicationInfo.sourceDir);
                Date systemDate = new Date(file.lastModified());
                ApplicationInfo applicationInfo = reInfo.activityInfo.applicationInfo;
                String activityName = reInfo.activityInfo.name;
                String pkgName = reInfo.activityInfo.packageName;
                String appLabel = (String) reInfo.loadLabel(pm);
                Drawable icon = reInfo.loadIcon(pm);
                mIsHasReayDb = false;
                Cursor c = mdb.rawQuery("select * from perpo where pkname = ?",
                                        new String[] { pkgName });
                while (c.moveToNext()) {
                    String pkname = c.getString(c.getColumnIndex("pkname"));
                    if (pkgName.equals(pkname)) {
                        mIsHasReayDb = true;
                        break;
                    }
                }

                if (!mIsHasReayDb) {
                    mdb.execSQL("insert into perpo(label,pkname,date,int,click) "
                                + "values (?,?,?,?,?)",
                                new Object[] { appLabel, pkgName, systemDate,
                                              mNumber,mNumber});
                }
                if(isEnglish(appLabel)) {
                    ContentValues contentvalues = new ContentValues();
                    contentvalues.put("label", appLabel);
                    mdb.update("perpo", contentvalues, "pkname = ?", new String[]{ pkgName });
                } else {
                    ContentValues contentvalues = new ContentValues();
                    contentvalues.put("label", appLabel);
                    mdb.update("perpo", contentvalues, "pkname = ?", new String[]{ pkgName });
                }
            }
        }

        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if ((actionId == EditorInfo.IME_ACTION_SEND)
                     || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                mEtext = mEditText.getText().toString().trim();
                mlistAppInfo.clear();
                mBrowseAppAdapter.notifyDataSetChanged();
                mlistAppInfo = new ArrayList<AppInfo>();
                querySqlAppinfo();
                isCheckedMap = new HashMap<Integer, Boolean>();
                mBrowseAppAdapter = new StartupMenuAdapter(this, mlistAppInfo ,isCheckedMap);
                //mBrowseAppAdapter = new StartupMenuAdapter(StartupMenuActivity.this,
                //                                            mlistAppInfo);
                gv_view.setAdapter(mBrowseAppAdapter);
                return true;
            }
            return false;
        }

        private TextWatcher watcher = new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                     int after) {}

            @Override
            public void afterTextChanged(Editable s) {
                mEtext = mEditText.getText().toString().trim();
                mlistAppInfo.clear();
                mBrowseAppAdapter.notifyDataSetChanged();
                mlistAppInfo = new ArrayList<AppInfo>();
                querySqlAppinfo();
                //mBrowseAppAdapter = new StartupMenuAdapter(StartupMenuActivity.this,
                //                                           mlistAppInfo);
                isCheckedMap = new HashMap<Integer, Boolean>();
                mBrowseAppAdapter = new StartupMenuAdapter(StartupMenuActivity.this,
                                                           mlistAppInfo ,isCheckedMap);
                gv_view.setAdapter(mBrowseAppAdapter);
            }
        };

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            case R.id.my_computer:
                /* start FileManager */
                for (int i=0;i<mlistAppInfo.size();i++) {
                    AppInfo appInfo = mlistAppInfo.get(i);
                    PackageManager pm = this.getPackageManager();
                    String packName  = appInfo.getPkgName();
                    if (packName.compareTo("com.cyanogenmod.filemanager") == 0) {
                        Intent intent = appInfo.getIntent();
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }
                break;
            case R.id.system_setting:
                if (android.os.Build.VERSION.SDK_INT > 13) {
                    startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                } else {
                    startActivity(new Intent(android.provider.Settings.ACTION_APN_SETTINGS)
                   .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                }
                break;
            case R.id.iv_view:
                mEtext = mEditText.getText().toString().trim();
                mlistAppInfo.clear();
                mBrowseAppAdapter.notifyDataSetChanged();
                mlistAppInfo = new ArrayList<AppInfo>();
                querySqlAppinfo();
                //mBrowseAppAdapter = new StartupMenuAdapter(StartupMenuActivity.this,
                //                                           mlistAppInfo);
                isCheckedMap = new HashMap<Integer, Boolean>();
                mBrowseAppAdapter = new StartupMenuAdapter(this, mlistAppInfo ,isCheckedMap);
                gv_view.setAdapter(mBrowseAppAdapter);
                break;
            case R.id.tv_sort_show:
                //sortShow();
                selectShow(v);
                break;
            case R.id.name_sort:
                mEditText.setText("");
                mTvSortShow.setText(R.string.name_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_down_arrow_gray);
                mPopupWindow.dismiss();
                nameSort();
                break;
            case R.id.time_sort:
                mEditText.setText("");
                mTvSortShow.setText(R.string.time_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_down_arrow_gray);
                mPopupWindow.dismiss();
                timeSort();
                break;
            /*case R.id.type_sort:
                mPopupWindow.dismiss();
                if (CLICKS == 3) {
                    CLICKS = 0;
                }
                CLICKS++;
                mEditText.setText("");
                mlistAppInfo.clear();
                mBrowseAppAdapter.notifyDataSetChanged();
                typeSort(CLICKS);
                break;*/
            case R.id.click_sort:
                mTvSortShow.setText(R.string.click_sort);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_down_arrow_gray);
                mPopupWindow.dismiss();
                mEditText.setText("");
                clickSort();
                break;
            case R.id.iv_arrow_white:
                sortShow();
                break;
            }
        }

        private void nameSort() {
            mlistAppInfo.clear();
            mBrowseAppAdapter.notifyDataSetChanged();
            mlistAppInfo = new ArrayList<AppInfo>();
            queryAppInfo();
            SharedPreferences.Editor edit = sharedPreference.edit();
            edit.putString("type", mNameSortText);
            edit.putInt("order", 1);
            edit.commit();
            if (mNameSortStatus == -1 && mOnlyNameSort) {
                Collections.reverse(mlistAppInfo);
                mOnlyNameSort = false;
                mIvArrowGray.setImageResource(R.drawable.ic_starter_rank_arrow_gray);
                edit.putString("type", mNameSortText);
                edit.putInt("order", -1);
                edit.commit();
            }

            //mBrowseAppAdapter = new StartupMenuAdapter(StartupMenuActivity.this, mlistAppInfo);
            isCheckedMap = new HashMap<Integer, Boolean>();
            mBrowseAppAdapter = new StartupMenuAdapter(this, mlistAppInfo ,isCheckedMap);
            gv_view.setAdapter(mBrowseAppAdapter);
        }

        private void timeSort() {
            mlistAppInfo.clear();
            mBrowseAppAdapter.notifyDataSetChanged();
            mlistAppInfo = new ArrayList<AppInfo>();
            queryAppInfo();
            SharedPreferences.Editor edit = sharedPreference.edit();
            edit.putString("type", mTimeSortText);
            edit.putInt("order", 1);
            edit.commit();

            timeAlgorithm();
            //mBrowseAppAdapter = new StartupMenuAdapter(StartupMenuActivity.this, mlistAppInfo);
            isCheckedMap = new HashMap<Integer, Boolean>();
            mBrowseAppAdapter = new StartupMenuAdapter(this, mlistAppInfo ,isCheckedMap);
            gv_view.setAdapter(mBrowseAppAdapter);
        }

        private void typeSort(int a) {
            PackageManager pm = this.getPackageManager();
            Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            List<ResolveInfo> resolveInfos = pm.queryIntentActivities(mainIntent, 0);
            Collections.sort(resolveInfos,new ResolveInfo.DisplayNameComparator(pm));
            if (mlistAppInfo != null) {
                mlistAppInfo.clear();
                for (ResolveInfo reInfo : resolveInfos) {
                    ApplicationInfo applicationInfo = reInfo.activityInfo.applicationInfo;
                    if (a == FILTER_ALL_APP ) {
                        appData(pm, reInfo);
                    } else if (a == FILTER_SYSYTEM_APP && isSystemApp(applicationInfo)) {
                        appData(pm, reInfo);
                    } else if (a == FILTER_THIRD_APP && !isSystemApp(applicationInfo)) {
                        appData(pm, reInfo);
                        if (CLICKS == 3) {
                            CLICKS = 0;
                        }
                    }
                }
            }
            //mBroAdapter = new StartupMenuAdapter(this, mlistAppInfo);
            isCheckedMap = new HashMap<Integer, Boolean>();
            mBroAdapter = new StartupMenuAdapter(this, mlistAppInfo ,isCheckedMap);
            gv_view.setAdapter(mBroAdapter);
        }

        private void clickSort() {
            mlistAppInfo.clear();
            mBrowseAppAdapter.notifyDataSetChanged();
            mlistAppInfo = new ArrayList<AppInfo>();
            querySqlAppinfo();
            Collections.sort(mlistAppInfo, new Comparator<AppInfo>() {
                public int compare(AppInfo lhs, AppInfo rhs) {
                    Double rScore = (double) rhs.getNumber();
                    Double iScore = (double) lhs.getNumber();
                    return (rScore.compareTo(iScore));
                }
            });
            SharedPreferences.Editor editor = sharedPreference.edit();
            editor.putString("type", mClickSortText);
            editor.putInt("order", 1);
            editor.commit();
            if (mClickSortStatus == -1) {
                Collections.reverse(mlistAppInfo);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_rank_arrow_gray);
                SharedPreferences.Editor edit = sharedPreference.edit();
                edit.putString("type", mClickSortText);
                edit.putInt("order", -1);
                edit.commit();
            }
            //mBroAdapter = new StartupMenuAdapter(this, mlistAppInfo);
            isCheckedMap = new HashMap<Integer, Boolean>();
            mBroAdapter = new StartupMenuAdapter(this, mlistAppInfo ,isCheckedMap);
            gv_view.setAdapter(mBroAdapter);
        }

        private void selectShow(View v) {
            mIvArrowGray.setImageResource(R.drawable.ic_starter_down_arrow_gray);
            if (v instanceof TextView) {
                TextView textView = (TextView) v;
                String textViewText = textView.getText().toString();
                if (textViewText.equals(mNameSortText)) {
                    mNameSortStatus = mNameSortStatus * -1;
                    mOnlyNameSort = true;
                    nameSort();
                } else if (textViewText.equals(mTimeSortText)) {
                    mTimeSortStatus = mTimeSortStatus * -1;
                    timeSort();
                } else if (textViewText.equals(mClickSortText)) {
                    mClickSortStatus = mClickSortStatus * -1;
                    clickSort();
                }
            }
        }

        private void querySqlAppinfo() {
            Cursor c = mdb.rawQuery("select distinct * from perpo", new String[] {});
            while (c.moveToNext()) {
                String label = c.getString(c.getColumnIndex("label"));
                String  pkgName = c.getString(c.getColumnIndex("pkname"));
                String stringDate = c.getString(c.getColumnIndex("date"));
                Drawable icon = null;
                Date date = null;
                try {
                    icon = getPackageManager().getApplicationIcon(pkgName);
                    date = ConverToDate(stringDate);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                int number = c.getInt(c.getColumnIndex("int"));
                if(label.toLowerCase().indexOf(mEtext.toLowerCase()) != -1) {
                    Intent intent = getPackageManager().getLaunchIntentForPackage(pkgName);
                    AppInfo appInfo = new AppInfo();
                    appInfo.setAppLabel(label);
                    appInfo.setPkgName(pkgName);
                    appInfo.setDate(date);
                    appInfo.setAppIcon(icon);
                    appInfo.setNumber(number);
                    appInfo.setIntent(intent);
                    mlistAppInfo.add(appInfo);
                } else if(TextUtils.isEmpty(mEtext)) {
                    Intent intent = getPackageManager().getLaunchIntentForPackage(pkgName);
                    AppInfo appInfo = new AppInfo();
                    appInfo.setAppLabel(label);
                    appInfo.setPkgName(pkgName);
                    appInfo.setDate(date);
                    appInfo.setAppIcon(icon);
                    appInfo.setNumber(number);
                    appInfo.setIntent(intent);
                    mlistAppInfo.add(appInfo);
                }
            }
        }

        public static boolean isEnglish(String str) {
            return str.matches("^[a-zA-Z]*");
        }

        public static Date ConverToDate(String StrDate) throws Exception {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(StrDate);
        }

        private void timeAlgorithm() {
            Collections.sort(mlistAppInfo, new Comparator<Object>() {
                public int compare(Object lhs, Object rhs) {
                    AppInfo p1 = (AppInfo) lhs;
                    AppInfo p2 = (AppInfo) rhs;
                    return p2.getDate().compareTo(p1.getDate());
                }
            });
            if (mTimeSortStatus == -1) {
                Collections.reverse(mlistAppInfo);
                mIvArrowGray.setImageResource(R.drawable.ic_starter_rank_arrow_gray);
                SharedPreferences.Editor editor = sharedPreference.edit();
                editor.putString("type", mTimeSortText);
                editor.putInt("order", -1);
                editor.commit();
            }

        }

        public void appData(PackageManager pm, ResolveInfo reInfo) {
            File file = new File(reInfo.activityInfo.applicationInfo.sourceDir);
            Date systemDate = new Date(file.lastModified());
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

        private boolean isSystemApp(ApplicationInfo applicationInfo) {
            return (applicationInfo.flags & applicationInfo.FLAG_SYSTEM) > 0;
        }

        /*public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String pkgName = mlistAppInfo.get(position).getPkgName();
            Intent intent = mlistAppInfo.get(position).getIntent();
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            doUpdate(pkgName);
        }*/

        public void doUpdate(String pkgName) {
            Cursor c = mdb.rawQuery("select * from perpo where pkname = ?", new String[] { pkgName });
            c.moveToNext();
            int numbers = c.getInt(c.getColumnIndex("int"));
            numbers++;
            ContentValues values = new ContentValues();
            values.put("int", numbers);
            mdb.update("perpo", values, "pkname = ?", new String[] { pkgName });
        }

        public void powerOff(View v) {
            ActivityManagerNative.callPowerSource(mContext);
            finish();
	}

        public void sortShow() {
            mIvArrowGray.setImageResource(R.drawable.ic_starter_rank_arrow_gray);

            mPopupWindow = new PopupWindow(mSelectLayout, FILTER_THIRD_APP_TYPE_UI_X,
                                           FILTER_THIRD_APP_TYPE_UI_Y);
            mPopupWindow.setFocusable(true);
            mPopupWindow.setOutsideTouchable(true);
            mPopupWindow.setBackgroundDrawable(new BitmapDrawable());

            int[] location = new int[2];
            mTvSortShow.getLocationOnScreen(location);
            //popupWindow.showAtLocation(v, Gravity.NO_GRAVITY,location[0] + v.getWidth(),
            //                           location[1]);
            mPopupWindow.showAtLocation(mTvSortShow, Gravity.BOTTOM, FILTER_THIRD_APP_TYPE_X,
                                        FILTER_THIRD_APP_TYPE_Y);
        }

        private void dismisTargetDialog(BaseSettingDialog newDialog){
            if(targetDialog != null) {
                targetDialog.dismiss();
            }
            targetDialog = newDialog;
        }

        private void killStartupMenu() {
            try {
                ActivityManagerNative.getDefault().killStartupMenu();
                System.exit(0);
            } catch (RemoteException e) {
            }
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (MotionEvent.ACTION_OUTSIDE == event.getAction()) {
                killStartupMenu();
            }

            // Delegate everything else to Activity.
            return super.onTouchEvent(event);
        }
}
