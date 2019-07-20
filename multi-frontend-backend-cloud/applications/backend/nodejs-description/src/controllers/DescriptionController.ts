import { Request, Response } from 'express-serve-static-core';

export namespace DescriptionController {

  const descriptions: { [key: string]: string } = {
    Ukrainian: 'Ukraine',
    French: 'Apart from France, Belgium and Switzerland this will also be understood in Morocco, Tunisia and Algeria and the sub-Saharan African countries of DR Congo, Côte d’Ivoire, Cameroon, Guinea, Gabon and Mauritius',
    Spanish: 'Outside Spain, Spanish, or Castillian as it is sometimes called, is the main language of all Central and South American countries apart from Brazil. It is also the second most common language in the USA, spoken by more than 34m Hispanic Americans',
    German: 'Germany, Austria and Switzerland',
    Italian: 'Italy',
    Portuguese: 'Portugal and Brazil. Also spoken in former Portuguese colonies of Angola, Mozambique, Cape Verde, São Tomé and Macau',
    Hindi: 'Northern India and Nepal. Hindi is one of the official languages of India, but is spoken as native language by only 41% of the population. Some people classify Hindi as the same language as Urdu, which is spoken in Pakistan',
    'Persian (Farsi)': 'Iran, Afghanistan, Tajikistan. Also parts of Uzbekistan and Bahrain. NB. Persian is sometimes called Farsi. That’s the local name for Persian as it is spoken in Iran',
    Russian: 'Russia, and as a first or second language in the Eastern European, Caucasian and Central Asian countries of the former USSR. Kazakhstan in particular has large numbers of ethnic Russians who speak Russian rather than Kazakh',
    Japanese: 'Japanese is spoken pretty much only in Japan. The greetings above are used in the morning, around midday and in the evening respectively',
    Korean: 'North and South Korea',
    Turkish: 'Turkish is spoken in Turkey and Cyprus. Also the languages spoken in Azerbeijan and parts of Iran, Georgia and the Balkans are very similar to Turkish',
    Mongolian: 'Mongolia. Mongolian speakers also live in some parts of Russia, China (Inner Mongolia) and Kyrgyzstan',
    Kazakh: 'Almost 7 million of the world’s 10 million Kazakh speakers live in Kazakhstan. The rest are divided between Xinxiang province in China, Uzbekistan, Russia, Mongolia, Turkmenistan, Ukraine and Tajikistan. As in Mandarin, the literal translation of this greeting is ‘how are you?’',
    Hungarian: 'Mostly in Hungary, although parts of Austria and the Balkans have Hungarian speakers',
    Arabic: 'Arabic in various dialects is spoken throughout North Africa and the Middle East. It is a main language in the following countries: Algeria, Bahrain, Chad, Egypt, Eritrea, Iraq, Israel, Jordan, Kuwait, Lebanon, Libya, Mauritania, Morocco, Oman, Palestine, Qatar, Saudi Arabia, Somalia, Sudan, Syria, Tunisia, UAE, Western Sahara, Yemen',
    Hausa: 'Hausa is the native language of inhabitants of Niger and Northern Nigeria, but it is also used as lingua franca in many countries of West and Central Africa',
    Swahili: 'Swahili has between 5 and 10 million native speakers who mainly live in Tanzania, Uganda and Kenya. But it is used as a lingua franca for most of East Africa and second language speakers swell the ranks to a massive 80 million!',
    Mandarin: 'Mandarin is the most spoken language in the world – it is spoken by at least 50% of China’s 1.3bn population',
    'Cantonese (Yue)': 'Southern China (especially Guangdong province), Hong Kong and Macau',
    'Bahasa Indonesia': 'Although there are over 300 different dialects spoken in Indonesia, Bahasa Indonesia is spoken by much of the population as a second language. It is also very similar to the Malay language of Malaysia'
  };

  export const getDescriptions = (req: Request, res: Response) => {
    res.status(200).json(descriptions);
  };

  export const getDescription = (req: Request, res: Response) => {
    const language: string = req.params.language;
    const languageCapitalized: string = language ? language.charAt(0).toUpperCase() + language.slice(1) : '';

    descriptions[languageCapitalized]
      ? res.status(200).json(descriptions[languageCapitalized])
      : res.status(400).send('Not Found');
  };

}
