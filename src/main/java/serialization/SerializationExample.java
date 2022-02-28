package serialization;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Base64;

public class SerializationExample {
    public static void main(String[] args) throws IOException {
        Member member = new Member("ludwings", "ludwings0330@gmail.com", 29);

        System.out.println("member.toString() = " + member.toString());


        Member m = new Member("창민", "ludwings@naver.com", 29);
        byte[] serializaedMember;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(m);
                serializaedMember = baos.toByteArray();
            }
        }
        // 바이트 배열로 생성된 직렬화 데이터를 base64로 변환
        System.out.println(Base64.getEncoder().encodeToString(serializaedMember));

        // CSV
        String csv = String.format("%s,%s,%d", m.getName(), m.getEmail(), m.getAge());
        System.out.println("csv = " + csv);

        // JSON
        String json = String.format("", member.getName(), member.getEmail(), member.getAge());
        System.out.println("json = " + json);
    }
}
