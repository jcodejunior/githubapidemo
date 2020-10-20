package com.example.apidemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apidemo.model.GitHubUser;
import com.example.apidemo.rest.APIClient;
import com.example.apidemo.rest.GitHubUserEndPoints;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.apidemo.Main_LoginActivity.username;

public class UserActivity extends Activity {

    private ImageView img_Avatar;
    private TextView txt_Name, txt_Email, txt_Login, txt_Location, txt_Followers, txt_Following, btn_OwnedRepos;
    private Button btn_Back;

    private Bundle extras;
    private String extraString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        img_Avatar = findViewById(R.id.img_avatar);
        txt_Name = findViewById(R.id.txt_Name);
        txt_Email = findViewById(R.id.txt_Email);
        txt_Login = findViewById(R.id.txt_Login);
        txt_Location = findViewById(R.id.txt_Location);
        txt_Followers = findViewById(R.id.txt_Followers);
        txt_Following = findViewById(R.id.txt_Following);
        btn_OwnedRepos = findViewById(R.id.btn_OwnedRepos);
        btn_Back = findViewById(R.id.btn_Back);
        btn_Back.setOnClickListener(v -> UserActivity.super.onBackPressed());
        btn_OwnedRepos.setOnClickListener(v -> startActivity(new Intent(getApplication(), RepoActivity.class).putExtra(username, extraString)));
        extras = getIntent().getExtras();
        if (extras != null) {
            extraString = extras.getString("EXTRA_STRING");
        }
        loadData();
    }

    private void loadData() {
        final GitHubUserEndPoints apiService =
                APIClient.getClient()
                        .create(GitHubUserEndPoints.class);

        Call<GitHubUser> call = apiService.getUser(extraString);
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call,
                                   Response<GitHubUser> response) {
                if (response.body() != null) {
                    txt_Name.append(response.body().getName() != null ? response.body().getName() : "/");
                    txt_Email.append(response.body().getEmail() != null ? response.body().getEmail() : "/");
                    txt_Login.append(response.body().getLogin());
                    txt_Location.append(response.body().getLocation() != null ? response.body().getLocation() : "unknown");
                    txt_Followers.append(response.body().getFollowers());
                    txt_Following.append(response.body().getFollowing());

                    Picasso.get().load(response.body().getAvatar()).into(img_Avatar);

                } else {
                    Toast.makeText(getApplication(), "An error occurred, error message is:\n" + response.message(), Toast.LENGTH_SHORT).show();
                UserActivity.super.onBackPressed();
                }
            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {
            }
        });
    }
}