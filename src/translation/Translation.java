package translation;

import java.util.Observable;

public class Translation extends Observable {
	private static Ilanguage lan = new English(); // default language

	// singleton
	private Translation() {
	}

	private static Translation instance;

	public static Translation getInstance() {
		if (instance == null)
			instance = new Translation();
		return instance;
	}

	// strategy
	public void setLanguage(Ilanguage lan) {
		this.lan = lan;
		updateLanguage();
	}
	
	// update observer
	public void updateLanguage() {
		super.setChanged();
		super.notifyObservers();
	}

	public String getYourName() {
		return lan.performYourName();
	}

	public String getStartName() {
		return lan.performStartName();
	}

	public String getSettingName() {
		return lan.performSettingName();
	}

	public String getHighScoreName() {
		return lan.performHighScoreName();
	}

	public String getTutorialName() {
		return lan.performTutorialName();
	}

	public String getLanguageName() {
		return lan.performLanguageName();
	}

	public String getExitName() {
		return lan.performExitName();
	}

	public String getCancleName() {
		return lan.performCancleName();
	}

	public String getRankName() {
		return lan.performRankName();
	}

	public String getPlayerName() {
		return lan.performPlayerName();
	}

	public String getScoreName() {
		return lan.performScoreName();
	}

	public String getTutorialImageName() {
		return lan.performTutorialImageName();
	}

	public String getRotateName() {
		return lan.performRotateName();
	}

	public String getRightName() {
		return lan.performRightName();
	}

	public String getSpeedName() {
		return lan.performSpeedName();
	}

	public String getLeftName() {
		return lan.performLeftName();
	}

	public String getGameOverName() {
		return lan.performGameOver();
	}

	public String getReadyName() {
		return lan.performReadyName();
	}

	public String getStartIconName() {
		return lan.performStartIconName();
	}

	public String getNextName() {
		return lan.performNextName();
	}

	public String getNewGameName() {
		return lan.performNewGameName();
	}

	public String getPauseName() {
		return lan.performPauseName();
	}

	public String getHomeName() {
		return lan.performHomeName();
	}

	public String getQuitName() {
		return lan.performQuitName();
	}

	public String getRestartName() {
		return lan.performRestartName();
	}

	public String getResumeName() {
		return lan.performResumeName();
	}

	public String getTitleQuestion() {
		return lan.performTitleQuestion();
	}

	public String getQuestion() {
		return lan.performQuestion();
	}

	public String getYesName() {
		return lan.performYesName();
	}

	public String getNoName() {
		return lan.performNoName();
	}

}