package io.quran.app.payload.api;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuranApiPojo{
    private Integer id;
    private Integer sura;
    private Integer aya;
    private String arabic_text;
    private String translation;
    private String footnotes;

    @Override
    public String toString() {
        return "QuranApiPojo{" +
                "id=" + id +
                ", sura=" + sura +
                ", aya=" + aya +
                ", arab_text='" + arabic_text + '\'' +
                ", translation='" + translation + '\'' +
                ", footnotes='" + footnotes + '\'' +
                '}';
    }
}
