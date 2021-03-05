import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Monster } from '../models/monster';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private monsterSource = new BehaviorSubject<any>(null);
  public selectedMonster = this.monsterSource.asObservable();

  constructor() { }

  changeSelectedMonster(monster: Monster) {
    this.monsterSource.next(monster);
  }
}
