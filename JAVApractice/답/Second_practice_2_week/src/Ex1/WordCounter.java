package Ex1;

public class WordCounter {
	String[] strArr;
	StringBuffer sb = new StringBuffer();
	int kor_word=0; // 한글
	int eng_word=0; // 영어
	int num_word=0; // 숫자
	int spe_word=0; // 특수문자
	public String countWord(String str){
		strArr = str.split(""); // 배열 초기화
		
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].matches("^[ㄱ-ㅎ가-힣]*$")) {
				kor_word++;
			}else if (strArr[i].matches("^[a-zA-Z]*$")) {
				eng_word++;
			}else if (strArr[i].matches("^[0-9]*$")) {
				num_word++;
			}
		}
		sb.append("### 카운트 결과 ###\r\n");
		sb.append("한글 : "+kor_word+"자\r\n");
		sb.append("영어 : "+eng_word+"자\r\n");
		sb.append("숫자 : "+num_word+"자\r\n");
		System.out.println(sb.toString());
		return sb.toString();
	}
}
