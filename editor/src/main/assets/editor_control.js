var _UEditor = UM.getEditor('myEditor', {
    //这里可以选择自己需要的工具按钮名称,此处仅选择如下七个
    toolbar: [],
    //focus时自动清空初始化时的内容
    autoClearinitialContent: true,
    //关闭字数统计
    wordCount: false,
    //关闭elementPath
    elementPathEnabled: false,
    //默认的编辑区域高度
    //initialFrameHeight:300
    //更多其他参数，请参考umeditor.config.js中的配置项
});

// 编辑器初始化完毕
_UEditor.ready(function () {
    alert("editorIsReady");
});

// 设置编辑器获取焦点
_UEditor.focus = function () {
    _UEditor.focus();
}

// 设置编辑器取消焦点
_UEditor.blur = function () {
    _UEditor.blur();
}

// 设置编辑区可用
_UEditor.setEnable = function () {
    _UEditor.setEnabled();
}

// 设置编辑区不可用
_UEditor.setDisabled = function () {
    _UEditor.setDisabled();
}

// 获取编辑器中的html内容
_UEditor.getContent = function () {
    return _UEditor.getContent();
}

// 撤销上一步操作
_UEditor.undo = function () {
    _UEditor.execCommand("undo");
}

// 恢复上一步操作
_UEditor.redo = function () {
    _UEditor.execCommand("redo");
}

// 清除输入内容
_UEditor.clear = function () {
    _UEditor.execCommand("cleardoc");
}

// 预览
_UEditor.preview = function () {
    _UEditor.execCommand("preview");
}

// 设置或取消粗体
_UEditor.bold = function () {
    _UEditor.execCommand("bold");
}

// 设置或取消斜体
_UEditor.italic = function () {
    _UEditor.execCommand("italic");
}

// 设置或取消下标
_UEditor.subscript = function () {
    _UEditor.execCommand("subscript");
}

// 设置或取消上标
_UEditor.superscript = function () {
    _UEditor.execCommand("superscript");
}

// 添加引用
_UEditor.blockquote = function () {
    _UEditor.execCommand("blockquote", {
        style: "color: gray; font-style: italic; margin: 5px 2px 2px 2px; padding: 10px 2px 2px 2px; border-left: 4px solid #ccc; background-color: #f1f1f1;"
    });
}

// 设置H1标题头
_UEditor.paragraphH1 = function() {
    _UEditor.execCommand("paragraph", "h1");
}

// 设置H2标题头
_UEditor.paragraphH2 = function() {
    _UEditor.execCommand("paragraph", "h2");
}

// 设置H3标题头
_UEditor.paragraphH3 = function() {
    _UEditor.execCommand("paragraph", "h3");
}

// 设置H4标题头
_UEditor.paragraphH4 = function() {
    _UEditor.execCommand("paragraph", "h4");
}

// 设置H5标题头
_UEditor.paragraphH5 = function() {
    _UEditor.execCommand("paragraph", "h5");
}

// 设置H6标题头
_UEditor.paragraphH6 = function() {
    _UEditor.execCommand("paragraph", "h6");
}

// 段落左对齐
_UEditor.justifyLeft = function () {
    _UEditor.execCommand("justifyleft");
}

// 段落居中对齐
_UEditor.justifyCenter = function () {
    _UEditor.execCommand("justifycenter");
}

// 段落左对齐
_UEditor.justifyRight = function () {
    _UEditor.execCommand("justifyright");
}

// 设置或取消删除线
_UEditor.strikeThrough = function () {
    _UEditor.execCommand("strikethrough");
}

// 设置或取消下划线
_UEditor.underLine = function () {
    _UEditor.execCommand("underline");
}

// 插入横向分割线
_UEditor.horizontalLine = function () {
    _UEditor.execCommand("horizontal");
}

// 插入图片
_UEditor.insertImage = function (imageUrl) {
    _UEditor.execCommand("insertimage", {
        src: imageUrl,
        width: "100%"
    });
}

// 插入一段html代码
_UEditor.insertHtml = function (html) {
    _UEditor.execCommand("inserthtml", html);
}

// 插入音乐
_UEditor.insertMusic = function (musicUrl) {
    _UEditor.execCommand("music", {
        align: "center",
        url: musicUrl
    });
}

// 插入视频
_UEditor.insertVideo = function (videoUrl) {
    _UEditor.execCommand("insertvideo", {
        url: videoUrl
    });
}

// 插入有序列表
_UEditor.insertOrderedList = function () {
    _UEditor.execCommand("insertorderedlist", "decimal");
}

// 插入无序列表
_UEditor.insertUnorderedList = function () {
    _UEditor.execCommand("insertunorderedlist", "dot");
}