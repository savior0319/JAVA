package Ex1;

public class WordCounter {
	String[] strArr;
	StringBuffer sb = new StringBuffer();
	int kor_word=0; // �ѱ�
	int eng_word=0; // ����
	int num_word=0; // ����
	int spe_word=0; // Ư������
	public String countWord(String str){
		strArr = str.split(""); // �迭 �ʱ�ȭ
		
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].matches("^[��-����-�R]*$")) {
				kor_word++;
			}else if (strArr[i].matches("^[a-zA-Z]*$")) {
				eng_word++;
			}else if (strArr[i].matches("^[0-9]*$")) {
				num_word++;
			}
		}
		sb.append("### ī��Ʈ ��� ###\r\n");
		sb.append("�ѱ� : "+kor_word+"��\r\n");
		sb.append("���� : "+eng_word+"��\r\n");
		sb.append("���� : "+num_word+"��\r\n");
		System.out.println(sb.toString());
		return sb.toString();
	}
}
