package com.zl.spbm.service.inter;

/**
 * 发送邮件
 * @author qk203
 *
 */
public interface IMailService {
	
	/**
	 * 发送邮件
	 * @param to 收件人
	 * @param subject 主题
	 * @param content 内容
	 */
	public void sendSimpleMail(String to, String subject, String content);
	/**
	 * html 格式发送邮件
	 * @param to 收件人
	 * @param subject 主题
	 * @param content 内容
	 */
	public void sendHtmlMail(String to, String subject, String content);
	
	/**
	 * 发送邮件支持附件
	 * @param to 收件人
	 * @param subject 主题
	 * @param content 内容
	 * @param filePath 附件路径
	 */
	public void sendAttachmentsMail(String to, String subject, String content, String filePath);
	
}
