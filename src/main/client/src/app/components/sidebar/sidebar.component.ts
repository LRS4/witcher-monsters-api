import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Monster } from '../../models/monster';
import { DataService } from '../../services/data.service';
import { MonsterService } from '../../services/monster.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.less']
})
export class SidebarComponent implements OnInit {
  
  public title = 'Monsters';
  public monsters: Monster[] = [];
  public selectedMonster: any;

  constructor(private monsterService: MonsterService,
    private dataService: DataService) { }

  ngOnInit() {
    this.getMonsters();
    this.dataService.selectedMonster.subscribe(selectedMonster => {
      return this.selectedMonster = selectedMonster;
    });
  }

  public getMonsters(): void {
    this.monsterService.getMonsters().subscribe(
      (response: Monster[]) => {
        this.monsters = response;
      }
    ),
    (error: HttpErrorResponse) => {
      console.log(error.message);
    }
  }

  public onSelect(selectedMonster: Monster) {
    this.selectedMonster = selectedMonster;
  }

}
