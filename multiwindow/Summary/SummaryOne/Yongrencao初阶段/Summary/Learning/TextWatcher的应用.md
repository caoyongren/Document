#####<center>EditText的TextWatcher的使用
***
**使用场景1：**
*布局中EditText在android布局中经常用到，对EditText中输入的内容页经常需要进行限制，我们可以通过TextWatcher去观察输入的内容来限制输入的字符数*

    mTextView = (TextView)findViewById(R.id.tv);
     TextWatcher mTextWatcher = new TextWatcher() {
        private CharSequence temp;
        private int editStart ;
        private int editEnd ;
        @Override
        public void beforeTextChanged(CharSequence s, int arg1/*开始的位置*/, int arg2,/*被改变的旧内容数*/
                int arg3) {
            temp = s;
            //这里的s表示改变之前的内容，通常start和count组合，可以在s中读取本次改变字段中被改变的内容。而after表示改变后新的内容的数量。
        }

        @Override
        public void onTextChanged(CharSequence s, int arg1, int arg2,
                int arg3/*改变后的内容数量*/) {
            mTextView.setText(s);
    //这里的s表示改变之后的内容，通常start和count组合，可以在s中读取本次改变字段中新的内容。而before表示被改变的内容的数量。
        }

        @Override
        public void afterTextChanged(Editable s) {//表示最终内容
            editStart = mEditText.getSelectionStart();
            editEnd = mEditText.getSelectionEnd();
            if (temp.length() > 10) {
                Toast.makeText(TextWatcherDemo.this,
                        "你输入的字数已经超过了限制！", Toast.LENGTH_SHORT)
                        .show();
                s.delete(editStart-1, editEnd);
                int tempSelection = editStart;
                mEditText.setText(s);
                mEditText.setSelection(tempSelection);
            }
        }
    };
***