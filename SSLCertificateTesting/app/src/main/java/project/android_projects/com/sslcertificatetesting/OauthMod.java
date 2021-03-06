package project.android_projects.com.sslcertificatetesting;

import com.google.gson.annotations.SerializedName;

public class OauthMod {
    @SerializedName("records")
    private Oauth mOauth = null;

    public Oauth getOauth() {
        return mOauth;
    }

    public void setOauth(Oauth mOauth) {
        this.mOauth = mOauth;
    }

    class Oauth {
        @SerializedName("email")
        private String mEmail = "";
        @SerializedName("password")
        private String mPassword = "";
        @SerializedName("token")
        private String mToken = "";
        @SerializedName("secret")
        private String mSecret = "";

        public String getEmail() {
            return mEmail;
        }

        public void setEmail(String mEmail) {
            this.mEmail = mEmail;
        }

        public String getmPassword() {
            return mPassword;
        }

        public void setmPassword(String mPassword) {
            this.mPassword = mPassword;
        }

        public String getAccessToken() {
            return mToken;
        }

        public void setAccessToken(String mToken) {
            this.mToken = mToken;
        }

        public String getSecret() {
            return mSecret;
        }

        public void setAccessSecret(String mSecret) {
            this.mSecret = mSecret;
        }
    }
}
