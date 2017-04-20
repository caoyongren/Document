### 对于android6.0实现-- > 窗口呈现的逻辑分析

    public final class ActivityStackSupervisor implements DisplayListener {
        /* ASS computeStackFocus中： AMS 的resizeStack(id , Rect); 
         *                          |
         *     resizeStack(int stackId, Rect bounds) {
         *        mStackSupervisor.resizeStackLocked(stackId, bounds); 
         *     } 
         *                          |
         * ASS resizeStackLocked(id, bounds){}方法；
         *                          |
         *     resizeStackLocked(int stackId, Rect bounds) {
         *       Configuration overrideConfig = mWindowManager.resizeStack(stackId, bounds); 
         *     }
         *                          |  
         * WMS -- > resizeStack(id, Rect);
         *                          |
         *     resizeStack() {
         *       if (stack.setBounds(bounds)) {
         *         stack.resizeWindows();
         *       } 
         *     }
         *                          |
         * TaskStack: -->  void setBounds() {}
         *                 void getBounds(Rect out) {}//getBounds对外提供调用。
         *                          |
         * WindowState --> void computeFrameLw(Rect pf, Rect df, Rect of, Rect cf, Rect vf, Rect dcf, Rect sf, Rect osf) {}
         *                          |
         *     computeFrameLw (...) {
         *       stack.getBounds(mContainingFrame);//mContainingFrame 是Rect
         *     }
         * Session extends IWindowSession.Stub --> relayout()
         *                          |
         *     relayout(...) {
         *          int res = mService.relayoutWindow(this, window, seq, attrs,
         *                           requestedWidth, requestedHeight, viewFlags, flags,
         *                           outFrame, outOverscanInsets, outContentInsets, outVisibleInsets,
         *                           outStableInsets, outsets, outConfig, outSurface);
         *     }
         *
         * ViewRootImpl -- >  relayoutWindow(...)
         *                          |
         *     relayoutTinyWindow (...) {
         *       int relayoutResult = mWindowSession.relayout(  //mWindowSession 属于IWindowSession
         *                        mWindow, mSeq, params,
         *                        (int) (mView.getMeasuredWidth() * appScale + 0.5f),
         *                        (int) (mView.getMeasuredHeight() * appScale + 0.5f),
         *                        viewVisibility, insetsPending ? WindowManagerGlobal.RELAYOUT_INSETS_PENDING : 0,
         *                        mWinFrame, mPendingOverscanInsets, mPendingContentInsets, mPendingVisibleInsets,
         *                        mPendingStableInsets, mPendingOutsets, mPendingConfiguration, mSurface);
         *     }
         *     //IWindowSession是AIDL ,Session 和 ViewRootImpl 通过AIDL通信。
         *
         *     ------ >WMS 中的 relayoutWindow(...)
         *     relayoutWindow(Session session, IWindow client, int seq,                                                                                           
         *                   WindowManager.LayoutParams attrs, int requestedWidth,
         *                   int requestedHeight, int viewVisibility, int flags,
         *                   Rect outFrame, Rect outOverscanInsets, Rect outContentInsets,
         *                   Rect outVisibleInsets, Rect outStableInsets, Rect outOutsets, Configuration outConfig,
         *                   Surface outSurface) {
         *                   //--> successfully
         *                   }
         *                             
         */
}
