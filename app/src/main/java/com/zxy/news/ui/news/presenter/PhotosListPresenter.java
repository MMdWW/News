package com.zxy.news.ui.news.presenter;

import com.zxy.news.R;
import com.zxy.news.bean.PhotoGirl;
import com.zxy.news.ui.news.contract.PhotoListContract;
import com.jaydenxiao.common.baserx.RxSubscriber;

import java.util.List;

/**
 * des:图片列表
 * Created by xsf
 * on 2016.09.12:01
 */
public class PhotosListPresenter extends PhotoListContract.Presenter {
    @Override
    public void getPhotosListDataRequest(int size, int page) {
             mRxManage.add(mModel.getPhotosListData(size,page).subscribe(new RxSubscriber<List<PhotoGirl>>(mContext,false) {
                 @Override
                 public void onStart() {
                     super.onStart();
                     mView.showLoading(mContext.getString(R.string.loading));
                 }
                 @Override
                 protected void _onNext(List<PhotoGirl> photoGirls) {
                     mView.returnPhotosListData(photoGirls);
                     mView.stopLoading();
                 }

                 @Override
                 protected void _onError(String message) {
                     mView.showErrorTip(message);
                 }
             }));
    }
}
