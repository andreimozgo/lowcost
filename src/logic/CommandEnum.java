package logic;

public enum CommandEnum {
	LOGIN {
		{
			this.command = new LoginCommand();
		}
	},
	LOGOUT {
		{
			this.command = new LogoutCommand();
		}
	},
	ADDFLIGHT {
		{
			this.command = new AddFlightCommand();
		}
	},
	REGISTRATION {
		{
			this.command = new RegistrationCommand();
		}
	},
	ADDREGISTRATION {
		{
			this.command = new AddRegistrationCommand();
		}
	};
	
	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}
