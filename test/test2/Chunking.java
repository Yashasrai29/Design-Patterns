package test.test2;

import java.util.*;

public class Chunking {

        public static void main(String[] args) {
            String movies = "Karuneye Kutumbada Kannu, Sri Kanyaka Parameshwari Kathe, Bhootayyana Maga Ayyu, Nodi Swamy Navirodu Hige, Rayaru Bandaru Mavana Manege, Krishna Nee Begane Baaro, Sukha Samsarakke Hanneradu Sootragalu, Undu Hoda Kondu Hoda, Pallavi Anu Pallavi, Edakallu Guddada Mele, Naa Ninna Bidalaare, Bhagyada Lakshmi Baramma, Putani Agent 123, Simhada Mari Sainya, Sose Thanda Sowbhagya, Mana Mecchida Madadi, Sri Ramanjaneya Yuddha, Goa Dalli CID 999, Operation Jackpot Nalli C.I.D 999, Operation Diamond Racket, Raja Nanna Raja, Naa Ninna Mareyalare, Huliya Haalina Mevu, Nee Nanna Gellalare, Nee Bareda Kadambari, Mathe Haditu Kogile, Nammoora Mandara Hoove, S.P. Sangliyana Part 2, Makkaliralavva Mane Thumba, Ondu Muttina Kathe, Alli Ramachari Illi Brahmachari, Avale Nanna Hendthi, Hendthi Helidare Kelabeku, Hendthi Endare Heegirabeku, Ganda Mane Makkalu, Thayige Thakka Maga, Thandege Thakka Maga, Ondu Oorina Kathe, Ondu Premada Kathe, Benkiyalli Aralida Hoovu, Ba nalle Madhuchandrake, Ba Nanna Preethisu, Prema Raga Haadu Gelathi, Bhale Adrushtavo Adrustha, Nanna Rosha Nooru Varusha, Daari Tappida Maga, Mooru Guttu Ondu Sullu Ondu Nija, Aaru Mooru Ombhatthu, Onde Balliya Hoogalu, Onde Rupa Eradu Guna, Gandhada Gudi Part 2, Neenu Nakkare Haalu Sakkare, Ganesha I Love You, Nanna Hendathi Kole, Hendthi Beku Hendthi, Hosa Mane Aliya, Aliya Alla Magala Ganda, Atthege Thakka Sose, Atthegondu Kaala Sosegondu Kaala, Devara Gedda Manava, Singapoorinalli Raja Kulla, Kulla Agent 000, Premave Balina Belaku, Parameshi Prema Prasanga, Haavu Eni Aata, Brahma Vishnu Maheshwara, Sri Venkateshwara Mahime, Maneli Ili Beedili Huli, Roll Call Ramakrishna, Ondu Cinema Kathe, Yaarige Saluthe Sambala, Swalpa Adjust Madkolli, Kranthiveera Sangolli Rayanna, Sri Srinivasa Kalyana, Sri Chamundeshwari Mahime, Sri Dharmasthala Mahathme, Sri Shaila Mahathme, Maduve Madi Nodu, Sri Krishna Rukmini Satyabhama, Devaru Kotta Thangi, Sri Krishna Devaraya, Shiva Mecchida Kannappa, Sathyam Shivam Sundaram, Ondu Hennu Aaru Kannu, Naa Mechida Huduga, Naa Mechida Hudugi, Nanna Kanasina Hoove, Avale Nanna Gelethi, Thayi Kotta Seere, Amara Shilpi Jakanachari, Bhakta Gnana Deva, Shri Krishna Gaarudi, Shri Krishna Tulabharam, Shri Krishna Paarijaatha, Nan Hendthi Chennagidale, Ranadheera Kanteerava, Jagajyothi Basveshwara, Mahishasura Mardini, Santha Thukaram, Satya Harishchandra";
            String [] list = movies.split(",");
            List<List<String>> ml = new ArrayList<>();
            int count = 0;
            List<String> each = new ArrayList<>();
            for(String word : list){
                each.add(word);
                count++;
                if(count == 20){
                    ml.add(new ArrayList<>(each));
                    count = 0;
                    each.clear();
                }
            }
            ml.add(new ArrayList<>(each));
            each.clear();
            for(List<String> li : ml){
                System.out.println(""+li.toString());
                System.out.println("------------------");
            }
        }

}
