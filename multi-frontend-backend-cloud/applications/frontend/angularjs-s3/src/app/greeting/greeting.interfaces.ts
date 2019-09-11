interface Family {
  description: string;
  name: string;
}

export interface Greeting {
  country: string;
  translation: string;
  description: string;
  family: Family;
}

export type Greetings = Greeting[];
