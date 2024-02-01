package solutions._07.classes;

public class CookieJar
{
    private int cookies;

    public CookieJar() {
        this(0);
    }

    public CookieJar(int cookies) {
        this.cookies = cookies;
    }

    public int count() {
        return this.cookies;
    }

    public boolean empty() {
        return this.count() == 0;
    }

    public void addCookie() {
        this.cookies ++;
    }

    public void addCookies(int quantity) {
        this.cookies += quantity;
    }

    public boolean takeCookie() {
        if (!this.empty()) {
            this.cookies --;

            return true;
        }

        return false;
    }

    public boolean takeCookies(int quantity) {
        if (this.count() >= quantity) {
            this.cookies -= quantity;

            return true;
        }

        return false;
    }
}
