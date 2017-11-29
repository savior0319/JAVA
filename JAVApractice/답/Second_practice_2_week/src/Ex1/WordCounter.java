package Ex1;

public class WordCounter {
	String[] strArr;
	StringBuffer sb = new StringBuffer();
	int kor_word=0; // ÇÑ±Û
	int eng_word=0; // ¿µ¾î
	int num_word=0; // ¼ıÀÚ
	int spe_word=0; // Æ¯¼ö¹®ÀÚ
	public String countWord(String str){
		strArr = str.split(""); // ¹è¿­ ÃÊ±âÈ­
		
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].matches("^[¤¡-¤¾°¡-ÆR]*$")) {
				kor_word++;
			}else if (strArr[i].matches("^[a-zA-Z]*$")) {
				eng_word++;
			}else if (strArr[i].matches("^[0-9]*$")) {
				num_word++;
			}
		}
		sb.append("### Ä«¿îÆ® °á°ú ###\r\n");
		sb.append("ÇÑ±Û : "+kor_word+"ÀÚ\r\n");
		sb.append("¿µ¾î : "+eng_word+"ÀÚ\r\n");
		sb.append("¼ıÀÚ : "+num_word+"ÀÚ\r\n");
		System.out.println(sb.toString());
		return sb.toString();
	}
}
