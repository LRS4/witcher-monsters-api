import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/services/data.service';
import vulnerabilitiesConstants from 'src/app/constants/vulnerabilities';

@Component({
  selector: 'app-vulnerabilities',
  templateUrl: './vulnerabilities.component.html',
  styleUrls: ['./vulnerabilities.component.less']
})
export class VulnerabilitiesComponent implements OnInit {

  public selectedMonster: any;
  public selectedMonsterVulnerabilities: string[] = [];
  public vulnerabilitiesConstants: any = vulnerabilitiesConstants;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.dataService.selectedMonster.subscribe(selectedMonster => {
      if (selectedMonster != null) {
        this.selectedMonster = selectedMonster;
        this.selectedMonsterVulnerabilities = selectedMonster.susceptibility.split(',');
      }
    });
  }

}
