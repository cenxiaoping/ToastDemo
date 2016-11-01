package spanlogistics.oxbix.com.toastdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class SizeUtils {
    /**
     * dip2px
     *
     * @param size
     * @return
     */
    public static int dip2px(int size, Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        return (int) (size * f + 0.5F);
    }

    /**
     * px2dip
     *
     * @param size
     * @return
     */
    public static int px2dip(int size, Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        return (int) (size / f + 0.5F);
    }

    /**
     * 动态设置 ListView 高度
     * @param listAdapter
     * @param listView
     */
    public static void setListViewItemHeight(ListAdapter listAdapter, ListView listView) {
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        listView.setLayoutParams(params);
    }

    /**
     * 动态 设置GridView 高度
     * @param listView
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static void setListViewHeightBasedOnChildren(GridView listView, int numColumns, int verticalSpacing) {
        // 获取listview的adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        // 固定列宽，有多少列
        int col = numColumns;
        int totalHeight = 0;
        // i每次加4，相当于listAdapter.getCount()小于等于4时 循环一次，计算一次item的高度，
        // listAdapter.getCount()小于等于8时计算两次高度相加
        for (int i = 0; i < listAdapter.getCount(); i += col) {
            // 获取listview的每一个item
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            // 获取item的高度和
            totalHeight += listItem.getMeasuredHeight() + verticalSpacing;
        }

        // 获取listview的布局参数
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        // 设置高度
        params.height = totalHeight;
        // 设置margin
//        ((ViewGroup.MarginLayoutParams) params).setMargins(10, 10, 10, 10);
        // 设置参数
        listView.setLayoutParams(params);
    }
}
