####<center>Snackbar的使用
***
    Snackbar.make(view, message, duration)
            .setAction(action message, click listener)
            .show();
**例子：**

    Snackbar.make(rootlayout, "Hello SnackBar!", Snackbar.LENGTH_SHORT)
        .setAction("Undo", new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        // Perform anything for the action selected
        }
        })
        .show();