package com.mry.servlet.validation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RandomValidateCode {
	public static final String RANDOMCODEKEY = "RANDOMVALIDATECODEKEY";
	private Random random = new Random();
	private static String randString = "123456789ABCDEFGHIJKLMNPQRSTUVWXYZ";

	private int width = 80;
	private int height = 26;
	private int lineSize = 40;
	private int stringNum = 4;
	
	public void createValidateCode(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		String randomString = generateRandonString();
		BufferedImage image = createRandomImage(randomString);

		session.removeAttribute(RANDOMCODEKEY);
		session.setAttribute(RANDOMCODEKEY, randomString);

		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
	}

	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc - 16);
		int g = fc + random.nextInt(bc - fc - 14);
		int b = fc + random.nextInt(bc - fc - 18);
		return new Color(r, g, b);
	}

	private BufferedImage createRandomImage(String code) {
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		g.setColor(getRandColor(110, 133));
		for (int i = 0; i <= lineSize; i++) {
			drowLine(g);
		}
		int len = code.length();
		for (int i = 0; i < len; i++) {
			drowString(g, code.charAt(i), i + 1);
		}
		g.dispose();
		return image;
	}

	private void drowString(Graphics g, char c, int index) {
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random
				.nextInt(121)));

		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(String.valueOf(c), 13 * index, 16);

	}

	private String generateRandonString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < stringNum; i++) {
			String rand = String.valueOf(getRandomString(random
					.nextInt(randString.length())));
			builder.append(rand);
		}
		return builder.toString();
	}

	private void drowLine(Graphics g) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int xl = random.nextInt(13);
		int yl = random.nextInt(15);
		g.drawLine(x, y, x + xl, y + yl);
	}

	private String getRandomString(int num) {
		return String.valueOf(randString.charAt(num));
	}
}
