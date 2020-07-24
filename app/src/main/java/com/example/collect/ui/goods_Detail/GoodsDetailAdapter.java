package com.example.collect.ui.goods_Detail;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.collect.R;
import com.example.collect.bean.GoodsDetail;
import com.example.collect.bean.GoodsDetailRelate;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;


import java.util.List;

public class GoodsDetailAdapter extends BaseMultiItemQuickAdapter<GoodsDetail.ResultBean, BaseViewHolder> {

    public GoodsDetailAdapter(List<GoodsDetail.ResultBean> data) {
        super(data);
        addItemType(GoodsDetail.ResultBean.TYPE_BANNER, R.layout.goods_banner);
        addItemType(GoodsDetail.ResultBean.TYPE_HTML, R.layout.goodshtml);
        addItemType(GoodsDetail.ResultBean.TYPE_TITLE, R.layout.goodstitle);
        addItemType(GoodsDetail.ResultBean.TYPE_ATTRBUTE, R.layout.goods_attribute);
        addItemType(GoodsDetail.ResultBean.TYPE_ISSUE, R.layout.goods_issue);
        addItemType(GoodsDetail.ResultBean.TYPE_GOODSLIST, R.layout.goodsadapter);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsDetail.ResultBean item) {
        switch (helper.getItemViewType()){
            case GoodsDetail.ResultBean.TYPE_BANNER:
                banner(helper,item);
                break;
            case GoodsDetail.ResultBean.TYPE_HTML:
                html(helper,item);
                break;
            case GoodsDetail.ResultBean.TYPE_TITLE:
                setTitle(helper,item);
                break;
            case GoodsDetail.ResultBean.TYPE_ISSUE:
                issue(helper,item);
                break;
            case GoodsDetail.ResultBean.TYPE_GOODSLIST:
                goodList(helper,item);
                break;
            case GoodsDetail.ResultBean.TYPE_ATTRBUTE:
                attribute(helper,item);
                break;
        }
    }

    private void goodList(BaseViewHolder helper, GoodsDetail.ResultBean item) {
        GoodsDetailRelate.DataBean.GoodsListBean data= (GoodsDetailRelate.DataBean.GoodsListBean) item.data;
        helper.setText(R.id.goods_name,data.getName());
        helper.setText(R.id.goods_price,"¥"+data.getRetail_price());
        ImageView image = helper.getView(R.id.good_img);
        Glide.with(mContext).load(data.getList_pic_url()).into(image);
    }

    private void issue(BaseViewHolder helper, GoodsDetail.ResultBean item) {
        GoodsDetail.DataBeanX.IssueBean data= (GoodsDetail.DataBeanX.IssueBean) item.data;
        helper.setText(R.id.question,data.getQuestion());
        helper.setText(R.id.answer,data.getAnswer());
    }

    private void attribute(BaseViewHolder helper, GoodsDetail.ResultBean item) {
        GoodsDetail.DataBeanX.AttributeBean data= (GoodsDetail.DataBeanX.AttributeBean) item.data;
        helper.setText(R.id.goods_attr,data.getName());
        helper.setText(R.id.goods_attr_value,data.getValue());
    }

    private void setTitle(BaseViewHolder helper, GoodsDetail.ResultBean item) {
        String data= (String) item.data;
        helper.setText(R.id.title_goods,data);
    }

    private void html(BaseViewHolder helper, GoodsDetail.ResultBean item) {
        String data= (String) item.data;
        WebView web = helper.getView(R.id.web);
        String css_str = mContext.getResources().getString(R.string.css_goods);
        StringBuilder sb = new StringBuilder();
        //html格式:html标签,head,style,body
        //对html的片段进行拼接,拼接成完整的html,并且添加了样式
        sb.append("<html><head>");
        sb.append("<style>"+css_str+"</style></head><body>");
        sb.append(data+"</body></html>");
        web.loadData(sb.toString(),"text/html", "utf-8");
    }

    private void banner(final BaseViewHolder helper, GoodsDetail.ResultBean item) {
        GoodsDetail.DataBeanX data=(GoodsDetail.DataBeanX)item.data;
        final List<GoodsDetail.DataBeanX.GalleryBean> gallery = data.getGallery();
        GoodsDetail.DataBeanX.InfoBean info = data.getInfo();
        helper.setText(R.id.goodsdetail_name,info.getName());
        helper.setText(R.id.goodsdetail_desc,info.getGoods_brief());
        helper.setText(R.id.goodspricedetail,"¥"+info.getRetail_price());
        Banner banner = helper.getView(R.id.banner);
        banner.setImages(gallery);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                GoodsDetail.DataBeanX.GalleryBean image= (GoodsDetail.DataBeanX.GalleryBean) path;
                Glide.with(context).load(image.getImg_url()).into(imageView);
            }
        }).start();
    }
}
