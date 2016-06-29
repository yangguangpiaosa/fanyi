package com.taozi.fanyi.utils.string;


public class StringValidateUtil {
	
	private String base = null;
	
	public StringValidateUtil(String str) {
		this.base = str;
	}
	
	private boolean passed = true;
	
	private static final String REG_NUMBERS = "^\\d*$";
	
	private static final String REG_EMAIL = "^([a-z0-9A-Z]+[-|\\._]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	
	/**
	 * validate not null
	 * @return
	 */
	public StringValidateUtil notNull() {
		this.passed &= (null != this.base && !"".equals(this.base));
		return this;
	}
	
	/**
	 * validate min length
	 * @param min
	 * @return
	 */
	public StringValidateUtil minLength(int min) {
		this.passed &= this.base.length() >= min;
		return this;
	}
	
	/**
	 * validate max length
	 * @param max
	 * @return
	 */
	public StringValidateUtil maxLength(int max) {
		this.passed &= this.base.length() <= max;
		return this;
	}
	
	/**
	 * validate if it can be convert to Integer
	 * @return
	 */
	public StringValidateUtil typeInt() {
		boolean flag = true;
		try {
			Integer.parseInt(this.base);
		} catch (NumberFormatException e) {
			flag = false;
		}
		this.passed &= flag;
		return this;
	}
	
	/**
	 * validate it consists of numbers
	 * @return
	 */
	public StringValidateUtil typeNumbers() {
		return this.regexCheck(REG_NUMBERS);
	}
	
	/**
	 * validate email format
	 * @return
	 */
	public StringValidateUtil typeEmail() {
		return this.regexCheck(REG_EMAIL);
	}
	
	/**
	 * validate emails format,split ','
	 * @return
	 */
	public StringValidateUtil typeEmails() {
		if(this.notNull().isPassed() && !this.base.startsWith(",") && !this.base.endsWith(",")) {
			for(String seg : this.base.split(","))
				this.passed &= new StringValidateUtil(seg).regexCheck(REG_EMAIL).isPassed();
		} else
			this.passed &= false;
		return this;
	}
	
	/**
	 * @param reg
	 * @return
	 */
	private StringValidateUtil regexCheck(String reg) {
		//this.passed &= Pattern.compile(reg).matcher(this.base).matches();
		this.passed &= this.base.matches(reg);
		return this;
	}
	
	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}
	
	public static void main(String[] args) {
		System.out.println(new StringValidateUtil("10").minLength(1).isPassed());
		System.out.println(new StringValidateUtil("10").maxLength(7).isPassed());
		System.out.println(new StringValidateUtil("10").typeInt().isPassed());
		System.out.println(new StringValidateUtil("10").typeNumbers().isPassed());
		System.out.println(new StringValidateUtil("ab@bc.com").typeEmail().isPassed());
		System.out.println(new StringValidateUtil(",test@cn.ibm.com,ab@bc.com").typeEmails().isPassed());
	}
	
}
