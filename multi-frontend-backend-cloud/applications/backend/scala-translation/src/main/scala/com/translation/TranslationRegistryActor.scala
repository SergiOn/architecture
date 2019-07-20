package com.translation

import akka.actor.{Actor, ActorLogging, Props}

object TranslationRegistryActor {
  final case object GetTranslations
  final case class GetTranslation(language: String)

  def props: Props = Props[TranslationRegistryActor]
//  def props(): Props = Props(new UserRegistryActor())
}

class TranslationRegistryActor extends Actor with ActorLogging {
  import TranslationRegistryActor._

  val translations: Map[String, String] = Map[String, String](
    "Ukrainian" -> "PRYVIT",
    "French" -> "BONJOUR",
    "Spanish" -> "HOLA",
    "German" -> "HALLO / GUTEN TAG ",
    "Italian" -> "CIAO",
    "Portuguese" -> "OLÀ",
    "Hindi" -> "NAMASTE",
    "Persian (Farsi)" -> "SALAAM",
    "Russian" -> "ZDRAS-TVUY-TE",
    "Japanese" -> "OHAYO / KONNICHIWA / KONBAN WA",
    "Korean" -> " AHN-YOUNG-HA-SE-YO",
    "Turkish" -> "MERHABA",
    "Mongolian" -> "SAIN BAINUU",
    "Kazakh" -> "SALEMETSIZ BE?",
    "Hungarian" -> "SZIA",
    "Arabic" -> "MARHABA",
    "Hausa" -> "SANNU / SALAMA ALEIKUM",
    "Swahili" -> "JAMBO / HABARI",
    "Mandarin" -> "NI HAU",
    "Cantonese (Yue)" -> "NAY HOH",
    "Bahasa Indonesia" -> "HALO",
    "French" -> "BONJOUR",
    "French" -> "BONJOUR",
  )

  def receive: Receive = {
    case GetTranslations =>
      sender() ! translations
    case GetTranslation(language) =>
      sender() ! translations.get(language.capitalize)
  }
}
