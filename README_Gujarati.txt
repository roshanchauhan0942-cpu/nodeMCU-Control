NodeMCU Control — Android Studio project

તમારા આપેલા ESP8266 કોડ પ્રમાણે આ એપ NODEMCU_CONTROL access point પર ચાલે છે.

કનેક્ટ કરવાની રીત:
1. NodeMCU પર તમારો હાલનો code upload કરો.
2. Android ફોનની Wi-Fi settings ખોલો.
3. NODEMCU_CONTROL નામના Wi-Fi સાથે જોડાઓ.
4. પાસવર્ડ: 12345678
5. Android Studio માં આ project ખોલો અને Run કરો; અથવા Build > Build APK(s) પસંદ કરો.
6. એપ ખોલતાં તે http://192.168.4.1/ ખોલશે. તમારા firmware ની હાલની webpage જ એપમાં દેખાશે.

મહત્વપૂર્ણ:
- આ project તમારા firmware માં ફેરફાર કરતું નથી. તે હાલની web page ને Android app ની અંદર ખોલે છે.
- ફોનમાં Wi-Fi જોડાયેલું હોવા છતાં “No internet” બતાવે તો “Stay connected / Use this network anyway” પસંદ કરો.
- જો તમારા કોડમાં AP SSID, password અથવા IP બદલો, તો MainActivity.java માં DEVICE_URL બદલો અને ફરી build કરો.
- APK અહીં પહેલેથી બનાવેલ નથી, કારણ કે build માટે Android SDK/Android Studio જરૂરી છે. આ ફોલ્ડર Android Studio માં ખોલીને APK બનાવી શકાય છે.
- આ app local Wi-Fi માટે છે; તે બહારથી ઇન્ટરનેટ દ્વારા control કરતી નથી.

વૈકલ્પિક: GitHub Actions વડે APK બનાવવી (Android Studio વગર)
1. GitHub પર નવું repository બનાવો.
2. આ ZIP extract કરીને તેની બધી ફાઇલો repository માં upload કરો; .github ફોલ્ડર પણ upload કરવો.
3. GitHub repository માં Actions tab ખોલો.
4. "Build NodeMCU Control APK" workflow ચલાવો.
5. Build સફળ થયા પછી Artifacts માંથી NodeMCU-Control-debug-apk ડાઉનલોડ કરો.
6. ZIP ખોલીને app-debug.apk તમારા Android ફોનમાં ઇન્સ્ટોલ કરો.
