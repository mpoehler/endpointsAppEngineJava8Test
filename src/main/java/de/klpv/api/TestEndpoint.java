package de.klpv.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import de.klpv.api.config.Constants;

@Api(name = "klpvApi", version = "v2",
        scopes = { "https://www.googleapis.com/auth/userinfo.email" },
        clientIds = {
                com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID,
                Constants.WEB_CLIENT_ID}
)
public class TestEndpoint {

    public class Result {
        String message;
        public Result(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    @ApiMethod(name = "sayHi", path = "sayHi")
    public Result sayHi(@Named("name") String name) {
        return new Result("Hi " + name);
    }

}