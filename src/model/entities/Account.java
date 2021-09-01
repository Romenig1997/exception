package model.entities;

import model.exceptions.BussinesExceptions;

public class Account {
		private Integer number;
		private String holder;
		private Double balance;
		private Double withDrawLimit;
		
		public Account() {
		}
		
		public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
			this.number = number;
			this.holder = holder;
			this.balance = balance;
			this.withDrawLimit = withDrawLimit;
		}

		public Integer getNumber() {
			return number;
		}
		public void setNumber(Integer number) {
			this.number = number;
		}
		
		public String getHolder() {
			return holder;
		}
		
		public void setHolder(String holder) {
			this.holder = holder;
		
		}
		public Double getBalance() {
			return balance;
		}
		
		public void setBalance(Double balance) {
			this.balance = balance;
		}


		public Double getWithDrawLimit() {
			return withDrawLimit;
		}
		
		public void deposit(Double amount) {
			balance += amount;
		}
		
		public void withDraw(Double amount) throws BussinesExceptions {
			validatewithDraw(amount);
			balance -= amount;
		}
		private void validatewithDraw(Double amount) throws BussinesExceptions {
			
			if (amount > withDrawLimit ) {
				throw new BussinesExceptions ("Withdraw error: The amount exceeds withdraw limit");
			}
			else if(amount > getBalance()){
				throw new BussinesExceptions("Error withdraw: Balance insufficient");
			}
				
		}
		
		@Override
		public String toString() {
			return number 
					+ " "
					+ holder
					+ " "
					+ balance 
					+ " "
					+ withDrawLimit;
		}
}
