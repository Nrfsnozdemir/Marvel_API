<h3 align="center">Marvel API</h3>

<!-- PROJECT LOGO --> 
<p align="center">
    <img src="images/marvel_dev.jpg" width="1000" height="600" title="marvel developer">
</p>

#### HOW TO GET CREDENTIALS:
1. Go to [Marvel developer portal.](https://developer.marvel.com)
2. Register or login.
3. Click **"My Developer Account"** to get your private and public keys.

```
You need to concatenate the timestamp + privateKey + publicKey (See the MarvelUtils class)

Ts - a timestamp (or other long string which can be changed on a request-by-request basis)
Hash - a md5 digest of the ts parameter, your private key and your public key (eg md5 (ts + privateKey + publicKey)
```
4. Create a **"configuration.properties"** file to store baseURI, ts, apiKey and hash.
(The API keys / secrets should not be stored with the code! :slightly_smiling_face:)