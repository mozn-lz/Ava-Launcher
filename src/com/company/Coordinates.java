package com.company;

import java.security.PrivateKey;

public class Coordinates {
    private:
        int longitude;
        int latitude;
        int height;

    public:
        public int getLongitude() {
            return longitude;
        }

        public int getLatitude() {
            return latitude;
        }

        public int getHeight() {
            return height;
        }

        ~Coordinates(int longitude, int latitude, int height) {

        }

}