package net.teacher.api.model.request;

public class ChangePassword {
	    private String oldPass;
	    private String newPass;

	    
	    public String getOldPass() {
	        return oldPass;
	    }

	    public void setOldPass(String oldPass) {
	        this.oldPass = oldPass;
	    }

	    public String getNewPass() {
	        return newPass;
	    }

	    public void setNewPass(String newPass) {
	        this.newPass = newPass;
	    }
}
