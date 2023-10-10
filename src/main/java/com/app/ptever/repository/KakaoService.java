package com.app.ptever.repository;


import com.app.ptever.domain.dto.UserDTO;
import com.app.ptever.domain.vo.UserProfileVO;
import com.app.ptever.domain.vo.UserVO;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Service
@Slf4j
public class KakaoService {
    public String getKakaoAccessToken(String code){
        String accessToken = null;
        String requestURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            // POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=c8b8e53a7e7ef6e2b7449cc4f0a8ac9f");
            sb.append("&redirect_uri=http://localhost:10000/login/kakao/callback");
            sb.append("&code=" + code);
            bw.write(sb.toString());
            bw.flush();

            if(connection.getResponseCode() == 200){
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                String result = "";

                while((line = br.readLine()) != null){
                    result += line;
                }

                JsonElement element = JsonParser.parseString(result);
                accessToken = element.getAsJsonObject().get("access_token").getAsString();

                br.close();
                bw.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return accessToken;
    }

    public Optional<UserDTO> getKakaoInfo(String token){
        String requestURL = "https://kapi.kakao.com/v2/user/me";
        UserDTO userDTO = null;

        try {
            URL url = new URL(requestURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Bearer " + token);
            if(connection.getResponseCode() == 200){
                userDTO = new UserDTO();
                BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line = null;
                String result = "";

                while((line = br.readLine()) != null){
                    result += line;
                }

                JsonElement element = JsonParser.parseString(result);
                JsonElement kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
                JsonElement profile = kakaoAccount.getAsJsonObject().get("profile").getAsJsonObject();

                userDTO.setUserKakaoEmail(kakaoAccount.getAsJsonObject().get("email").getAsString());
                userDTO.setUserNickname(profile.getAsJsonObject().get("nickname").getAsString());
                userDTO.setUserProfilePath(profile.getAsJsonObject().get("thumbnail_image_url").getAsString());
                userDTO.setUserLoginCode("KAKAO");


                br.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(userDTO);
    }

}
