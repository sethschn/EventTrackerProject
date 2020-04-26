import { Emotion } from './emotion';
export class Tracker {
  id: number;
  description: string;
  emotion: Emotion;
  logDate: string;

  constructor(id?: number, emotion?: Emotion, description?: string, logDate?: string ){
    this.id = id;
    this.description = description;
    this.emotion = emotion;
    this.logDate = logDate;
  }
}
