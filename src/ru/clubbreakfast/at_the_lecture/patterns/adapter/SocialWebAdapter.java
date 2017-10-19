package ru.clubbreakfast.at_the_lecture.patterns.adapter;

public class SocialWebAdapter implements SocialWeb {

    private Context context;

    public SocialWebAdapter(Context context) {
        this.context = context;
    }

    @Override
    public void getFriends(int userId) {
        if (context instanceof Vk) {
            Vk vk = (Vk) context;
            vk.getFriends(userId);
        } else if (context instanceof Fb) {
            Fb fb = (Fb) context;
            fb.getContacts(userId, null);
        }
    }

    @Override
    public boolean postMessage(String message, int userId) {
        if (context instanceof Vk) {
            Vk vk = (Vk) context;
            vk.post(message, userId, true);
        } else if (context instanceof Fb) {
            Fb fb = (Fb) context;
            fb.postMessage(message, userId);
        }
        return true;
    }
}
