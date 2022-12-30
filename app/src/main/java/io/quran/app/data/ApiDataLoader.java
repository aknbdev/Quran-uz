// package io.quran.app.data;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import io.quran.app.utils.QuranAPI;
// import io.quran.db.repository.verse.VerseRepository;

// @Configuration
// public class ApiDataLoader {
    
//     @Bean
//     CommandLineRunner commandLineRunner(QuranAPI quranAPI, VerseRepository verseRepository) {

//         return (args) -> {

//             quranAPI.getVersesFromApi().forEach((id, verse) -> {
//                 verseRepository.save(verse);
//             });
//         };
//     }
// }
