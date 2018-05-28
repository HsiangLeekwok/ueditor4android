package com.hlk.lib.android.ueditor;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;

/**
 * <b>功能描述：</b>UEditor<br />
 * <b>创建作者：</b>Hsiang Leekwok <br />
 * <b>创建时间：</b>2018/05/14 10:51 <br />
 * <b>作者邮箱：</b>xiang.l.g@gmail.com <br />
 * <b>最新版本：</b>Version: 1.0.0 <br />
 * <b>修改时间：</b>2018/05/14 10:51 <br />
 * <b>修改人员：</b><br />
 * <b>修改备注：</b><br />
 */
public class UEditor extends WebView {

    private static final String EDITOR_HTML = "file:///android_asset/editor.html";

    public UEditor(Context context) {
        this(context, null);
    }

    public UEditor(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.webViewStyle);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public UEditor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getSettings().setDomStorageEnabled(true);
        setVerticalScrollBarEnabled(true);
        setHorizontalScrollBarEnabled(false);
        if (!isInEditMode()) {
            getSettings().setJavaScriptEnabled(true);
        }
        setWebChromeClient(new UEditorWebChromeClient());
        setWebViewClient(new UEditorWebViewClient());
        loadUrl(EDITOR_HTML);
    }

    /**
     * 设置编辑区是否可以编辑
     */
    public void setEnable(boolean enable) {
        if (enable) {
            exec("javascript:_UEditor.setEnable();");
        } else {
            exec("javascript:_UEditor.setDisabled();");
        }
    }

    /**
     * 设置编辑器获取焦点
     */
    public void setFocus() {
        exec("javascript:_UEditor.focus();");
    }

    /**
     * 取消焦点
     */
    public void clearFocus() {
        exec("javascript:_UEditor.blur();");
    }

    /**
     * 撤销上一次命令
     */
    public void undo() {
        exec("javascript:_UEditor.undo();");
    }

    /**
     * 重新执行上一次命令
     */
    public void redo() {
        exec("javascript:_UEditor.redo();");
    }

    /**
     * 清空编辑区的内容
     */
    public void clearContent() {
        exec("javascript:_UEditor.clear();");
    }

    /**
     * 预览编辑的内容
     */
    public void preview() {
        exec("javascript:_UEditor.preview();");
    }

    /**
     * 设置或取消粗体
     */
    public void bold() {
        exec("javascript:_UEditor.bold();");
    }

    /**
     * 设置或取消斜体
     */
    public void italic() {
        exec("javascript:_UEditor.italic();");
    }

    /**
     * 设置或取消删除线
     */
    public void strikeThrough() {
        exec("javascript:_UEditor.strikeThrough();");

    }

    /**
     * 设置或取消下划线
     */
    public void underLine() {
        exec("javascript:_UEditor.underLine();");
    }

    /**
     * 插入分割线
     */
    public void horizontalLine() {
        exec("javascript:_UEditor.horizontalLine();");
    }

    /**
     * 设置或取消上标
     */
    public void superscript() {
        exec("javascript:_UEditor.superscript();");
    }

    /**
     * 设置或取消下标
     */
    public void subscript() {
        exec("javascript:_UEditor.subscript();");
    }

    /**
     * 添加引用
     */
    public void blockQuote() {
        exec("javascript:_UEditor.blockquote();");
    }

    /**
     * 设置H1-H6标题样式
     */
    public void headline(int size) {
        exec("javascript:_UEditor.paragraphH" + size + "();");
        insertHtml("<p></p>");
    }

    /**
     * 插入有序列表
     */
    public void orderedList() {
        exec("javascript:_UEditor.insertOrderedList();");
    }

    /**
     * 插入无序列表
     */
    public void unorderedList() {
        exec("javascript:_UEditor.insertUnorderedList();");
    }

    /**
     * 设置文字左对齐
     */
    public void alignLeft() {
        exec("javascript:_UEditor.justifyLeft();");
    }

    /**
     * 设置文字居中对齐
     */
    public void alignCenter() {
        exec("javascript:_UEditor.justifyCenter();");
    }

    /**
     * 设置文字右对齐
     */
    public void alignRight() {
        exec("javascript:_UEditor.justifyRight();");
    }

    /**
     * 插入图片
     */
    public void insertImage(String imageUrl) {
        exec("javascript:_UEditor.insertImage('" + imageUrl + "');");
    }

    /**
     * 插入html代码
     */
    public void insertHtml(String html) {
        exec("javascript:_UEditor.insertHtml('" + html + "');");
    }

    /**
     * 插入音频
     */
    public void insertMusic(String musicUrl) {
        exec("javascript:_UEditor.insertMusic('" + musicUrl + "');");
    }

    /**
     * 插入视频
     */
    public void insertVideo(String videoUrl) {
        exec("javascript:_UEditor.insertVideo('" + videoUrl + "');");
    }

    /**
     * 获取html内容
     */
    public void getContent() {
        if (biggerThanKitkat()) {
            exec("javascript:_UEditor.getContent();", new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String value) {

                }
            });
        } else {
            exec("javascript:alert('content:' + _UEditor.getContent())");
        }
    }

    /**
     * 获取markdown内容
     */
    public void getMarkdown() {

    }

    private void exec(String trigger) {
        exec(trigger, null);
    }

    private void exec(String trigger, ValueCallback<String> resultCallback) {
        if (biggerThanKitkat()) {
            evaluateJavascript(trigger, resultCallback);
        } else {
            loadUrl(trigger);
        }
    }

    private boolean biggerThanKitkat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
    }

    private class UEditorWebViewClient extends WebViewClient {

        @Nullable
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            WebResourceResponse response = interceptRequest(url);
            if (null != response) {
                return response;
            }
            return super.shouldInterceptRequest(view, url);
        }

        @Nullable
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                WebResourceResponse response = interceptRequest(request.getUrl().getPath());
                if (null != response) {
                    return response;
                }
            }
            return super.shouldInterceptRequest(view, request);
        }

        private WebResourceResponse interceptRequest(String url) {
            if (url.endsWith(".js") || url.endsWith(".css")) {
                String path = url.replace("file:///android_asset/", "");
                try {
                    return new WebResourceResponse("application/x-javascript", "utf-8", getContext().getAssets().open(path));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    private void handleAlertResult(String message) {
        if (!TextUtils.isEmpty(message)) {
            if (message.equals("editorIsReady")) {
                if (null != onEditorReadyListener) {
                    onEditorReadyListener.onReady();
                }
            } else if (message.startsWith("content:") || message.startsWith("markdown:")) {
                if (null != onContentFetchingListener) {
                    onContentFetchingListener.onContentFetched(message);
                }
            }
        }
    }

    private class UEditorWebChromeClient extends WebChromeClient {

        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            handleAlertResult(message);
            result.confirm();
            return true;
        }
    }

    private OnEditorReadyListener onEditorReadyListener;

    /**
     * 设置Editor的ready回调
     */
    public void setOnEditorReadyListener(OnEditorReadyListener l) {
        onEditorReadyListener = l;
    }

    public interface OnEditorReadyListener {
        void onReady();
    }

    private OnContentFetchingListener onContentFetchingListener;

    public void setOnContentFetchingListener(OnContentFetchingListener l) {
        onContentFetchingListener = l;
    }

    public interface OnContentFetchingListener {
        void onContentFetched(String content);
    }

    /**
     * 左对齐
     */
    public static final int ALIGN_LEFT = -1;
    /**
     * 居中对齐
     */
    public static final int ALIGN_CENTER = 0;
    /**
     * 右对齐
     */
    public static final int ALIGN_RIGHT = 1;

    @IntDef({ALIGN_LEFT, ALIGN_CENTER, ALIGN_RIGHT})
    public @interface AlignType {
    }
}
