package authenticate;

import java.util.regex.Pattern;

public class Account {
    private static final int PASSWORD_LEN = 6;
    private String email;
    private String pwd;

    public Account(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (isValidEmail(email)) this.email = email;
        else {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        if (isValidPassword(pwd)) this.pwd = pwd;
        else {
            throw new IllegalArgumentException("Invalid password");
        }
    }

    /**
     * Email validation pattern.
     */
    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );


    /**
     * Validates if the given input is a valid email address.
     *
     * @param email The email to validate.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();

    }

    public static boolean isValidPassword(String password) {
        boolean foundDigit = false, foundSymbol = false;
        if  (password == null ||
                password.length() < PASSWORD_LEN)
            return false;
        for (int i=0; i<password.length(); i++) {
            if (Character.isDigit(password.charAt(i)))
                foundDigit = true;
            if (!Character.isLetterOrDigit(password.charAt(i)))
                foundSymbol = true;
        }
        return foundDigit && foundSymbol;
    }

}
