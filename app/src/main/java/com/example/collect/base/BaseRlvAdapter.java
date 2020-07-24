package com.example.collect.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

//适配器封装之后要通用
//T 是当前适配器列表数据的泛型
public abstract class BaseRlvAdapter<T> extends RecyclerView.Adapter<BaseRlvAdapter.BaseViewHolder> {
    public final Context mContext;
    public final ArrayList<T> mList;
    private OnItemClickListener mOnItemClickListener;

    public BaseRlvAdapter(Context context, ArrayList<T> list){
        mContext = context;
        mList = list;
    }

    /**
     * 创建viewholder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public BaseRlvAdapter.BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //除了布局外其他的父类可以直接写
        View inflate = LayoutInflater.from(mContext).inflate(getLayout(), parent, false);
        BaseViewHolder holder = new BaseViewHolder(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener!=null){
                    //通过holder拿到position
                    mOnItemClickListener.onItemClick(inflate,holder.getLayoutPosition());
                }
            }
        });
        return holder;
    }

    //由子类提供布局
    protected abstract int getLayout();

    /**
     * 处理ui的核心方法
     * 绑定数据,怎么样就可以把数据设置上去了? 控件,数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull BaseRlvAdapter.BaseViewHolder holder, int position) {
        T t = mList.get(position);
        bindData(holder,t);
    }

    protected abstract void bindData(BaseRlvAdapter.BaseViewHolder holder, T t);

    /**
     * 获取子条目数量的
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return mList.size();
    }

    //添加更多数据,加载更多时使用
    public void addData(List<T> list){
        if (list != null && list.size() > 0) {
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    //刷新数据,下拉刷新使用
    public void updateData(List<T> list){
        if (list!=null && list.size()>0){
            mList.clear();
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }


    //viewholder里面是要查找控件并保存成成员变量的
    //但是因为这个viewholder在父类中,父类也不知道子类中有哪些控件
    //如果将findViewByid及保存控件交给子类,那么就必须写一个子类出来,那就和系统的
    //RecyclerView.ViewHolder一样了,这个类就失去作用了
    //应该在这个类中完成找控件+存储控件的功能
    //使用viewholder 的好处就是避免不必要的findviewbyid
    public static class BaseViewHolder extends RecyclerView.ViewHolder{

        //为了不用每次的findViewbyid,这里拿容器去把找出来的控件存储起来
        //没有findviewbyid的find,找过的去容器里面拿
        //ArrayMap,SparseArray 都是Android专门搞得容器,比hashmap要轻量级
        SparseArray<View> mViews = new SparseArray();

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            ///在findViewById的时候,这个类并不知道究竟是哪个控件的id
            //itemView.findViewById(R.id.xx);

        }

        //通过viewholder的一个方法去帮我们找控件
        public View findView(@IdRes int id){
            View view = mViews.get(id);
            //如果容器中没有这个控件
            if (view==null){
                //找控件
                view= itemView.findViewById(id);
                //存储控件
                mViews.append(id,view);
            }
           return view;
        }

        //设置文本
        public void setText(@IdRes int id,String text){
            try {
                TextView view = (TextView) findView(id);
                view.setText(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //子条目点击事件
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

}
