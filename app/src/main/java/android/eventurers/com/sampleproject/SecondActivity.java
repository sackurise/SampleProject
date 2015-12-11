package android.eventurers.com.sampleproject;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private ImageView imageView, imgAnimated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();
        setDefaults();
        setupEvents();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Cheese Name");
    }

    private void init()
    {
        imageView = (ImageView)findViewById(R.id.backdrop);
        imgAnimated = (ImageView)findViewById(R.id.animimage);
        fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    private void setupEvents()
    {

        imageView.setImageResource(R.drawable.cheese);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                Intent intent = new Intent(SecondActivity.this, HomeSlidingViewPager.class);
                startActivity(intent);
            }
        });
    }

    private void setDefaults()
    {
        Animation animation = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.animforrepeatimage);
        imgAnimated.setAnimation(animation);
    }
}
