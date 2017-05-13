package tech.zafrani.pubgapp.maps.actions;


public abstract class Action {

    private boolean shouldShow = false;

    public void toggle() {
        this.shouldShow = !shouldShow;
        onToggleAction();
    }

    public boolean shouldShow() {
        return this.shouldShow;
    }

    /**
     * Remove any references that may cause leaks.
     */
    public void release(){

    }

    protected abstract void onToggleAction();

}