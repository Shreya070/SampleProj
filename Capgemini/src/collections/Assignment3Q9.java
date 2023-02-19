package collections;
import java.util.*;

class SavingAccount implements Comparable<SavingAccount> 
{

	private double acc_balance;
	private int acc_ID;
	private String accountHolderName;
	private boolean isSalaryAccount;

	public SavingAccount(double acc_balance, int acc_ID, String accountHolderName, boolean isSalaryAccount) 
	{
		this.acc_balance = acc_balance;
		this.acc_ID = acc_ID;
		this.accountHolderName = accountHolderName;
		this.isSalaryAccount = isSalaryAccount;
	}

	public double getAcc_balance() 
	{
		return acc_balance;
	}

	public void setAcc_balance(double acc_balance) 
	{
		this.acc_balance = acc_balance;
	}

	public int getAcc_ID() 
	{
		return acc_ID;
	}

	public void setAcc_ID(int acc_ID) 
	{
		this.acc_ID = acc_ID;
	}

	public String getAccountHolderName() 
	{
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) 
	{
		this.accountHolderName = accountHolderName;
	}

	public boolean isSalaryAccount() 
	{
		return isSalaryAccount;
	}

	public void setSalaryAccount(boolean isSalaryAccount) 
	{
		this.isSalaryAccount = isSalaryAccount;
	}

	@Override
	public int compareTo(SavingAccount sav) 
	{
		if (this.acc_ID > sav.acc_ID) 
		{
			return 1;
		} 
		else if (this.acc_ID < sav.acc_ID) 
		{
			return -1;
		} 
		else 
		{
			return 0;
		}
	}

}

class BankAccountList 
{
	private TreeSet<SavingAccount> savingAccounts = new TreeSet<>();

	public boolean addSavingAccount(SavingAccount savingAccount) 
	{
		if (savingAccount != null) 
		{
			savingAccounts.add(savingAccount);
			return true;
		}
		return false;

	}

	public List<Integer> displaySavingAccountIds() 
	{
		Iterator<SavingAccount> iterator = savingAccounts.iterator();
		List<Integer> list = new ArrayList<>();
		
		while (iterator.hasNext()) {
			list.add(iterator.next().getAcc_ID());
		}
		return list;
	}
}

public class Assignment3Q9 
{
	public static void main(String[] args) 
	{

		SavingAccount Account1 = new SavingAccount(1000.20, 113, "Shreya", true);
		SavingAccount Account2 = new SavingAccount(1530.27, 102, "Rashi", false);
		SavingAccount Account3 = new SavingAccount(2100.90, 206, "Raj", true);

		BankAccountList accounts = new BankAccountList();
		accounts.addSavingAccount(Account1);
		accounts.addSavingAccount(Account2);
		accounts.addSavingAccount(Account3);

		System.out.println(accounts.displaySavingAccountIds());
	}
}