package com.hlk.ueditor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hlk.lib.android.ueditor.UEditor;
import com.hlk.lib.ueditor.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ueditor)
    UEditor uEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_block_quote,
            R.id.btn_bold,
            R.id.btn_horizontal_line,
            R.id.btn_insert_image,
            R.id.btn_insert_audio,
            R.id.btn_insert_html,
            R.id.btn_insert_video,
            R.id.btn_italic,
            R.id.btn_under_line,
            R.id.btn_superscript,
            R.id.btn_subscript,
            R.id.btn_justify_center,
            R.id.btn_justify_left,
            R.id.btn_justify_right,
            R.id.btn_ordered_list,
            R.id.btn_unordered_list,
            R.id.btn_preview,
            R.id.btn_redo,
            R.id.btn_undo,
            R.id.btn_strike_through})
    void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_undo:
                uEditor.undo();
                break;
            case R.id.btn_redo:
                uEditor.redo();
                break;
            case R.id.btn_preview:
                uEditor.preview();
                break;
            case R.id.btn_bold:
                uEditor.bold();
                break;
            case R.id.btn_italic:
                uEditor.italic();
                break;
            case R.id.btn_under_line:
                uEditor.underLine();
                break;
            case R.id.btn_strike_through:
                uEditor.strikeThrough();
                break;
            case R.id.btn_horizontal_line:
                uEditor.horizontalLine();
                break;
            case R.id.btn_superscript:
                uEditor.superscript();
                break;
            case R.id.btn_subscript:
                uEditor.subscript();
                break;
            case R.id.btn_block_quote:
                uEditor.blockQuote();
                break;
            case R.id.btn_unordered_list:
                uEditor.unorderedList();
                break;
            case R.id.btn_ordered_list:
                uEditor.orderedList();
                break;
            case R.id.btn_justify_left:
                uEditor.alignLeft();
                break;
            case R.id.btn_justify_center:
                uEditor.alignCenter();
                break;
            case R.id.btn_justify_right:
                uEditor.alignRight();
                break;
            case R.id.btn_insert_image:
                uEditor.insertImage("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo_top_ca79a146.png");
                break;
            case R.id.btn_insert_html:
                uEditor.insertHtml("<p><font color=\"#00FF00\">插入HTML带颜色</font></p>");
                break;
            case R.id.btn_insert_audio:
                String audioUrl = "http://fs.w.kugou.com/201710032347/6abc568894072d5d639ed1f5b37b951a/G099/M03/1F/13/ow0DAFkeuuCAeit6AEPTiPhYbms541.mp3";
                String audioHtml = "<audio src=\"" + audioUrl + "\" controls=\"controls\" preload=\"none\">" +
                        "Your browser does not support the audio tag.</audio>";
                uEditor.insertHtml(audioHtml);
                // uEditor.insertMusic(audioUrl);
                break;
            case R.id.btn_insert_video:
                String videoUrl = "http://media.w3.org/2010/05/sintel/trailer.mp4";
                String videoHtml = "<video src=\"" + videoUrl + "\" controls=\"controls\" preload=\"none\" webkit-playsinline playsinline x5-playsinline x-webkit-airplay=\"allow\">" +
                        "Your user agent does not support the HTML5 Audio element.</video>";
                uEditor.insertHtml(videoHtml);
                // uEditor.insertVideo(videoUrl);
                break;
        }
    }
}
